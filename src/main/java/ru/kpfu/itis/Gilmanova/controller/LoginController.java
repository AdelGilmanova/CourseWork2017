package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adel on 30.04.2017.
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String renderLoginPage(Boolean error, ModelMap model) {
        //request.setAttribute("error", error);
        model.put("error", "Неверный логин или пароль.");
        return "main";
    }

}
