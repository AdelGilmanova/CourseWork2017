package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.*;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class MainPageController extends BaseController{
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
        return "main";
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
        return "main";
    }

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public String renderSectionsPage(ModelMap model) {
        model.put("sections", sectionService.findAll());
        return "sections";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String renderServicesPage() {
        return "services";
    }

    @RequestMapping(value = "/clinicalExamination", method = RequestMethod.GET)
    public String renderClinicalExaminationPage() {
        return "clinicalExamination";
    }

    @RequestMapping(value = "/cardForm", method = RequestMethod.GET)
    public String renderСardFormPage() {
        return "cardForm";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String renderSchedulePage() {
        return "schedule";
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String renderAppointmentPage() {
        return "appointment";
    }

}
