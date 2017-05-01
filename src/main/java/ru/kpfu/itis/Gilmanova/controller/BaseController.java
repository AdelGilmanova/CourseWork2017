package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adel on 30.04.2017.
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
