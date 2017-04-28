package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class MainPageController {
    private static final String MAIN_PAGE_MAPPING = "/main";

    @RequestMapping(value = MAIN_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderMainPage() {
        return "main";
    }
}
