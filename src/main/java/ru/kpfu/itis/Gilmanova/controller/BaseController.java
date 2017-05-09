package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kpfu.itis.Gilmanova.service.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adel on 30.04.2017.
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected PatientService patientService;
    @Autowired
    protected SickCardService sickCardService;
    @Autowired
    protected AddressService addressService;
    @Autowired
    protected DoctorService doctorService;
    @Autowired
    protected SectionService sectionService;
    @Autowired
    protected ServiceService serviceService;
    @Autowired
    protected ScheduleService scheduleService;
    @Autowired
    protected UserService userService;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
