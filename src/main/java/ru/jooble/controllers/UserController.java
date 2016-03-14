package ru.jooble.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.jooble.controllers.forms.UserForm;
import ru.jooble.controllers.validator.UserFromValidator;
import ru.jooble.domain.User;
import ru.jooble.service.UserService;

@Controller
public class UserController {
    public static final String ALL_USER = "allUser";
    @Autowired
    UserFromValidator userFromValidator;
    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userFromValidator);
    }

    @RequestMapping(value = "/all/user", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return ALL_USER;
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {
        model.addAttribute("userForm", new UserForm());
        return "saveUser";
    }

    @RequestMapping(value = "/save/user/{id}", method = RequestMethod.GET)
    public String showPageEditUser(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("userForm", new UserForm(userService.getById(id)));
        return "saveUser";
    }

    @RequestMapping(value = "/save/user/", method = RequestMethod.POST)
    public String addUser(@Validated UserForm userForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "saveUser";
        }
        userService.insert(new User(0, userForm.getFirstName(), userForm.getLastName()));
        return showAllUsers(model);
    }

    @RequestMapping(value = "/save/user/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable(value = "id") Long id, @Validated UserForm userForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "saveUser";
        }
        userService.update(new User(id, userForm.getFirstName(), userForm.getLastName()));
        return showAllUsers(model);
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public RedirectView deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return new RedirectView("/all/user");
    }
}
