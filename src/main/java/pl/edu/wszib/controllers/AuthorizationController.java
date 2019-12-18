package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;
import pl.edu.wszib.services.IUserService;

import java.util.List;

public class AuthorizationController {

    @Autowired
    IAuthenticationService authenticationService;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("errorMessage", "");
        return "loginForm";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute("userModel") User user, Model model) {
        model.addAttribute("errorMessage", "złe dane !!!");
        model.addAttribute("userModel", new User());
        return "loginForm";
    }
}
