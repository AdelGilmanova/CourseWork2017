package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.Gilmanova.entity.Doctor;
import ru.kpfu.itis.Gilmanova.entity.SickCard;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class DoctorController extends BaseController{
    private static final String DOCTOR_PAGE_MAPPING = "/doctor";
    private static final String CARD_FORM_PAGE_MAPPING = "/cardForm";

    @RequestMapping(value = DOCTOR_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderDoctorPage(ModelMap model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_DOCTOR")) {
                Long userId = user.getUserInfo().getId();
                model.put("user", user.getUserInfo());
                model.put("doctor", doctorService.getDoctorByUserId(userId));
                model.put("address", addressService.getAddressByUserId(userId));
                return "doctor";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = CARD_FORM_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderCardFormPage() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_DOCTOR")) {
                return "cardForm";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = CARD_FORM_PAGE_MAPPING, method = RequestMethod.POST)
    public String cardFormPage(@RequestParam(required = false) Integer number,
                               RedirectAttributes redirectAttributes) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetail user = (MyUserDetail) object;
        Long patientId = patientService.getUserIdByNumberId(number);
        if (patientId == null) {
            redirectAttributes.addFlashAttribute("msg", "Карта не найдена.");
            return "redirect:/doctor";
        } else {
            Doctor doctor = doctorService.getDoctorByUserId(user.getUserInfo().getId());
            redirectAttributes.addFlashAttribute("patient", patientService.getPatientByPatientId(patientId));
            redirectAttributes.addFlashAttribute("user", user.getUserInfo());
            redirectAttributes.addFlashAttribute("cards",
                    sickCardService.getPatientCardsByDoctorId(patientId, doctor.getId()));
            return "redirect:/cardForm";
       }
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String addNote(@RequestParam(required = false) String date,
                          @RequestParam(required = false) String complaint,
                          @RequestParam(required = false) String diagnosis,
                          @RequestParam(required = false) String treatment,
                          @RequestParam(required = false) String results,
                          @RequestParam(required = false) Long patientId,
                          RedirectAttributes redirectAttributes) throws ParseException {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetail user = (MyUserDetail) object;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date day = new Date(dateFormat.parse(date).getTime());
        SickCard sickCard = new SickCard();
        sickCard.setStart(day);
        sickCard.setDiagnosis(diagnosis);
        sickCard.setTreatment(treatment);
        sickCard.setComplaints(complaint);
        sickCard.setResults(results);
        sickCard.setPatient(patientService.getPatientByUserId(patientId));
        sickCard.setDoctor(doctorService.getDoctorByUserId(user.getUserInfo().getId()));
        sickCardService.addNote(sickCard);
        redirectAttributes.addFlashAttribute("msg", "Данные успешно добавлены.");
        redirectAttributes.addFlashAttribute("patient", patientService.getPatientByUserId(patientId));
        redirectAttributes.addFlashAttribute("user", user.getUserInfo());
        redirectAttributes.addFlashAttribute("cards", sickCardService.getCardsByUserId(patientId));
        return "redirect:/cardForm";
    }

    @RequestMapping(value = "/updateCard/{cardId}/{patientId}", method = RequestMethod.GET)
    public String updateCard(@PathVariable("cardId") Long cardId,
                             @PathVariable("patientId") Long patientId,
                             ModelMap model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetail user = (MyUserDetail) object;
        model.put("patient", patientService.getPatientByPatientId(patientId));
        model.put("user", user.getUserInfo());
        model.put("card", sickCardService.getCardByCardId(cardId));
        return "changeCardForm";
    }

    @RequestMapping(value = "/updateNote", method = RequestMethod.POST)
    public String updateNote(@RequestParam(required = false) String start,
                             @RequestParam(required = false) String finish,
                             @RequestParam(required = false) String complaint,
                             @RequestParam(required = false) String diagnosis,
                             @RequestParam(required = false) String treatment,
                             @RequestParam(required = false) String results,
                             @RequestParam(required = false) Long cardId,
                             @RequestParam(required = false) Long patientId,
                             RedirectAttributes redirectAttributes) throws ParseException {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetail user = (MyUserDetail) object;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date startDay = new Date(dateFormat.parse(start.replace('.', '/')).getTime());
        Date finishDay = new Date(dateFormat.parse(finish.replace('.', '/')).getTime());
        SickCard sickCard = sickCardService.getCardByCardId(cardId);
        sickCard.setStart(startDay);
        sickCard.setFinish(finishDay);
        sickCard.setDiagnosis(diagnosis);
        sickCard.setTreatment(treatment);
        sickCard.setComplaints(complaint);
        sickCard.setResults(results);
        sickCard.setPatient(patientService.getPatientByUserId(patientId));
        sickCard.setDoctor(doctorService.getDoctorByUserId(user.getUserInfo().getId()));
        sickCardService.addNote(sickCard);
        redirectAttributes.addFlashAttribute("msg", "Данные успешно изменены.");
        redirectAttributes.addFlashAttribute("patient", patientService.getPatientByUserId(patientId));
        redirectAttributes.addFlashAttribute("user", user.getUserInfo());
        redirectAttributes.addFlashAttribute("cards", sickCardService.getCardsByUserId(patientId));
        return "redirect:/cardForm";
    }
}
