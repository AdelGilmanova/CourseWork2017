package ru.kpfu.itis.Gilmanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.Gilmanova.entity.Address;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.entity.Schedule;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Adel on 23.04.2017.
 */
@Controller
public class AdminController extends BaseController {
    private static final String ADMIN_PAGE_MAPPING = "/admin";
    private static final String NEW_CARD_ADDITION_PAGE_MAPPING = "/addNewCard";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = ADMIN_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderAdminPage() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_ADMIN")) {
                return "admin";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = NEW_CARD_ADDITION_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderCardAdditionPage() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_ADMIN")) {
                return "cardAddition";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String cardAdditionPage(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String secondName,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer growth,
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String pass,
            @RequestParam(required = false) String allergy,
            @RequestParam(required = false) Integer cardNumber,
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String house,
            @RequestParam(required = false) Integer flat,
            @RequestParam(required = false) Integer index,
            RedirectAttributes redirectAttributes) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date bday = new Date(dateFormat.parse(date).getTime());
        UserInfo user = new UserInfo();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSecondName(secondName);
        user.setHashPass(passwordEncoder.encode(pass));
        user.setLogin(login);
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        UserInfo user2 = userService.addUser(user);

        Address address = new Address();
        address.setArea(area);
        address.setCity(city);
        address.setFlat(flat);
        address.setHouse(house);
        address.setStreet(street);
        address.setIndex(index);
        address.setUserInfo(user2);
        addressService.addAddress(address);

        Patient patient = new Patient();
        patient.setAllergy(allergy);
        patient.setBirthday(bday);
        patient.setCard_number(cardNumber);
        patient.setGender(gender);
        patient.setGrowth(growth);
        patient.setImage("/images/mine/photo.png");
        patient.setUserInfo(user2);
        patientService.addPatient(patient);

        if (user2 != null) {
            redirectAttributes.addFlashAttribute("msg", "Новая карта успешно добавлена.");
        }
        return "redirect:/addNewCard";
    }

    /*
     *  Проверка уникальности номера карты AJAX
     */
    @ResponseBody
    @RequestMapping(value = "/checkingCardNumber", method = RequestMethod.POST)
    public String checkingLogin(@RequestParam Integer cardNumber) {
        return patientService.checkСardNumber(cardNumber);
    }

    /*
     *  Проверка уникальности логина AJAX
     */
    @ResponseBody
    @RequestMapping(value = "/checkingLogin", method = RequestMethod.POST)
    public String checkingLogin(@RequestParam String login) {
        return userService.checkLogin(login);
    }

    @RequestMapping(value = "/changeSchedule", method = RequestMethod.GET)
    public String renderScheduleChangingPage(ModelMap model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_ADMIN")) {
                model.put("doctors", doctorService.findAll());
                model.put("schedule", scheduleService.findAll());
                return "changingSchedule";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
    public String addSchedule(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String finish,
            @RequestParam(required = false) String room,
            @RequestParam(required = false) Long doctorId,
            RedirectAttributes redirectAttributes) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date day = new Date(dateFormat.parse(date).getTime());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Time startTime = new Time(timeFormat.parse(start).getTime());
        Time finishTime = new Time(timeFormat.parse(finish).getTime());
        Schedule schedule = new Schedule();
        schedule.setDay(day);
        schedule.setStart(startTime);
        schedule.setFinish(finishTime);
        schedule.setRoom(room);
        schedule.setStatus(true);
        schedule.setDoctor(doctorService.getDoctorById(doctorId));
        Schedule schedule2 = scheduleService.addSchedule(schedule);

        if (schedule2 != null) {
            redirectAttributes.addFlashAttribute("msg", "Новая карта успешно добавлена.");
        }
        return "redirect:/changeSchedule";
    }

    @RequestMapping(value = "/deleteSchedule", method = RequestMethod.POST)
    public String deleteSchedule(@RequestParam Long schId,
                                 RedirectAttributes redirectAttributes) {
        scheduleService.deleteSchedule(schId);
        redirectAttributes.addFlashAttribute("msg", "Данные удалены.");
        return "redirect:/changeSchedule";
    }
}
