package ru.jooble.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.jooble.controllers.forms.PurseForm;
import ru.jooble.controllers.validator.PurseFromValidator;
import ru.jooble.domain.Purse;
import ru.jooble.service.CurrencyService;
import ru.jooble.service.PurseService;
import ru.jooble.service.UserService;

import java.math.BigDecimal;


@Controller
@RequestMapping("/")
public class PurseController {
    public static final String ALL_PURSE = "allPurse";
    public static final String ERROR_PAGE = "errorPage";
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private PurseService purseService;
    @Autowired
    private UserService userService;
    @Autowired
    private PurseFromValidator purseFromValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(purseFromValidator);
    }


    @RequestMapping(method = RequestMethod.GET)
    public String showPageAllPurses(ModelMap model) {
        model.addAttribute("purses", purseService.getAll());
        return ALL_PURSE;
    }

    @RequestMapping(value = "/save/purse", method = RequestMethod.GET)
    public String showPageAddPurse(ModelMap model) {
        model.addAttribute("purseForm", new PurseForm());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("currencies", currencyService.getAll());
        return "savePurse";
    }

    @RequestMapping(value = "/save/purse/{id}", method = RequestMethod.GET)
    public String showPageEditPurse(@PathVariable(value = "id") Long id, ModelMap model) {
        Purse purse = purseService.getById(id);
        if (purse == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("purseForm", new PurseForm(purse));
        model.addAttribute("users", userService.getAll());
        model.addAttribute("currencies", currencyService.getAll());
        return "savePurse";
    }

    @RequestMapping(value = "/save/purse", method = RequestMethod.POST)
    public String savePurse(@Validated PurseForm purseForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("currencies", currencyService.getAll());
            return "savePurse";
        }
        if ("".equals(purseForm.getId())) {
            purseService.insert(new Purse(0, purseForm.getName(), Integer.parseInt(purseForm.getCurrencyId()), Integer.parseInt(purseForm.getOwnerId()), new BigDecimal(purseForm.getAmount())));
        } else {
            purseService.update(new Purse(Integer.parseInt(purseForm.getId()), purseForm.getName(), Integer.parseInt(purseForm.getCurrencyId()), Integer.parseInt(purseForm.getOwnerId()), new BigDecimal(purseForm.getAmount())));
        }
        return showPageAllPurses(model);
    }

    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id) {
        purseService.deleteById(id);
        return new RedirectView("/");
    }
}


