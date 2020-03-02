package com.elv.catmvcthymeleaf.web;

import com.elv.catmvcthymeleaf.entities.User;
import com.elv.catmvcthymeleaf.service.IUserService;
import com.elv.catmvcthymeleaf.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private IUserService userService;

    public RegistrationController() {
        super();
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(HttpServletRequest request, Model model){
        UserDto accountDto = new UserDto();
        model.addAttribute("user", accountDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult bindingResult,
            HttpServletRequest request, Errors errors){
        User registered = new User();
        if (!bindingResult.hasErrors()) {
            registered = createUserAccount(accountDto, bindingResult);
        }
        if (registered == null) {
            bindingResult.rejectValue("email", "message.regError");
        }

        return new ModelAndView("successRegister", "user", accountDto);
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try{
            registered = userService.registerNewUserAccount(accountDto);
        } catch (UserAlreadyExistException e) {
           return null;
        }
        return registered;
    }
}
