package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class MainPageController {
    private static final String MAIN_PAGE_MAPPING = "/";

    @RequestMapping(value = MAIN_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderMainPage() {
        return "main";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String renderServicesPage() {
        return "services";
    }

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public String renderSectionsPage() {
        return "sections";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String renderPatientPage() {
        return "patient";
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public String renderDoctorPage() {
        return "doctor";
    }

    @RequestMapping(value = "/clinicalExamination", method = RequestMethod.GET)
    public String renderClinicalExaminationPage() {
        return "clinicalExamination";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String renderSchedulePage() {
        return "schedule";
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String renderAppointmentPage() {
        return "appointment";
    }

    @RequestMapping(value = "/cardForm", method = RequestMethod.GET)
    public String rendercardFormPage() {
        return "cardForm";
    }

}
