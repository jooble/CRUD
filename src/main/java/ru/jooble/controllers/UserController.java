package ru.jooble.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import ru.jooble.controllers.forms.UserForm;
import ru.jooble.controllers.validator.UserFromValidator;
import ru.jooble.domain.User;
import ru.jooble.service.UserService;

@Controller
public class UserController {
    public static final String ALL_USER = "allUser";
    public static final String SAVE_USER = "saveUser";
    public static final String ERROR_PAGE = "errorPage";
    @Autowired
    private UserFromValidator userFromValidator;
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
        return SAVE_USER;
    }

    @RequestMapping(value = "/save/user/{id}", method = RequestMethod.GET)
    public String showPageEditUser(@PathVariable(value = "id") Long id, ModelMap model) {
        User user = userService.getById(id);
        if (user == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("userForm", new UserForm(user));
        return SAVE_USER;
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.POST)
    public String saveUser(@Validated UserForm userForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return SAVE_USER;
        }
        if ("".equals(userForm.getId())) {
            userService.insert(new User(userForm.getFirstName(), userForm.getLastName()));
        } else {
            User user = (new User(userForm.getFirstName(), userForm.getLastName()));
            user.setId(Long.parseLong(userForm.getId()));
            userService.update(user);
        }
        return "redirect:/all/user";
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public RedirectView deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return new RedirectView("/all/user");
    }
}
