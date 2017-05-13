package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class MainController extends BaseController {
    private static final String MAIN_PAGE_MAPPING = "/";
    private static final String PATIENT_PAGE_MAPPING = "/patient";
    private static final String SECTIONS_PAGE_MAPPING = "/sections";
    private static final String SERVICES_PAGE_MAPPING = "/services";
    private static final String SCHEDULE_PAGE_MAPPING = "/schedule";
    private static final String CLINICAL_EXAMINATION_PAGE_MAPPING = "/clinicalExamination";
    private static final String APPOINTMENT_PAGE_MAPPING = "/appointment";

    @RequestMapping(value = MAIN_PAGE_MAPPING, method = RequestMethod.GET)
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

    @RequestMapping(value = PATIENT_PAGE_MAPPING, method = RequestMethod.GET)
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

    @RequestMapping(value = SECTIONS_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderSectionsPage(ModelMap model) {
        model.put("sections", sectionService.findAll());
        return "sections";
    }

    @RequestMapping(value = SERVICES_PAGE_MAPPING + "/{id}", method = RequestMethod.GET)
    public String renderServicesPage(ModelMap model, @PathVariable("id") Long sectionId) {
        model.put("services", serviceService.getServiceBySectionId(sectionId));
        model.put("section", sectionService.getSection(sectionId));
        return "services";
    }

    @RequestMapping(value = SCHEDULE_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderSchedulePage(ModelMap model) {
        model.put("schedule", scheduleService.findAll());
        return "schedule";
    }

    @RequestMapping(value = CLINICAL_EXAMINATION_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderClinicalExaminationPage() {
        return "clinicalExamination";
    }

    @RequestMapping(value = APPOINTMENT_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderAppointmentPage() {
        return "appointment";
    }

}
