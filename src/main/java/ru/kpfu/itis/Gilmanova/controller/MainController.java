package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import ru.kpfu.itis.Gilmanova.service.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class MainController extends BaseController {
    //private static final String MAIN_PAGE_MAPPING = "/";

    @Autowired
    private PatientService patientService;
    @Autowired
    private SickCardService sickCardService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.equals("anonymousUser")) {
            String role = ((MyUserDetail) user).getUserInfo().getRole();
            if (role.equals("ROLE_USER")) return "redirect:/patient";
            if (role.equals("ROLE_DOCTOR")) return "redirect:/doctor";
            if (role.equals("ROLE_ADMIN")) return "redirect:/admin";
        }
        return "main";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String renderPatientPage(ModelMap model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_USER")) {
                Long userId = user.getUserInfo().getId();
                model.put("user", user.getUserInfo());
                model.put("patient", patientService.getPatientByUserId(userId));
                model.put("cards", sickCardService.getCardsByUserId(userId));
                model.put("address", addressService.getAddressByUserId(userId));
                return "patient";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
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

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public String renderSectionsPage(ModelMap model) {
        model.put("sections", sectionService.findAll());
        return "sections";
    }

    @RequestMapping(value = "/services/{id}", method = RequestMethod.GET)
    public String renderServicesPage(ModelMap model, @PathVariable("id") Long sectionId) {
        model.put("services", serviceService.getServiceBySectionId(sectionId));
        model.put("section", sectionService.getSection(sectionId));
        return "services";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String renderSchedulePage(ModelMap model) {
        model.put("schedule", scheduleService.findAll());
        return "schedule";
    }

    @RequestMapping(value = "/cardForm", method = RequestMethod.GET)
    public String renderСardFormPage() {
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

    @RequestMapping(value = "/cardForm", method = RequestMethod.POST)
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
            redirectAttributes.addFlashAttribute("patient", patientService.getPatientByUserId(patientId));
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

//    @RequestMapping(value = "/updateCard/{id}", method = RequestMethod.GET)
//    public String updateCard(@PathVariable("id") Long cardId) {
//        return "redirect:/cardForm";
//    }

    @RequestMapping(value = "/clinicalExamination", method = RequestMethod.GET)
    public String renderClinicalExaminationPage() {
        return "clinicalExamination";
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String renderAppointmentPage() {
        return "appointment";
    }

}
