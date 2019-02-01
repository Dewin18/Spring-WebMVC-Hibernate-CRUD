package de.spring.controller;
import de.spring.entity.User;
import de.spring.services.UserCRUDServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserCRUDServiceIF CRUDService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {

        model.addAttribute("user", new User());
        return "registerFormView";
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
    public String processFormPOST(HttpServletRequest request, @ModelAttribute("user") User user) {
        CRUDService.saveUser(user);
        request.getSession().setAttribute("user", user);
        return "redirect:/register/confirmation";
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String processFormGET() {

        return "processFormView";
    }
}