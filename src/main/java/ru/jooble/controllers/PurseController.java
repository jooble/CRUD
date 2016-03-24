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
import ru.jooble.controllers.forms.PurseForm;
import ru.jooble.controllers.validator.PurseFromValidator;
import ru.jooble.domain.Currency;
import ru.jooble.domain.Purse;
import ru.jooble.domain.User;
import ru.jooble.service.CurrencyService;
import ru.jooble.service.PurseService;
import ru.jooble.service.UserService;

import java.math.BigDecimal;


@Controller
@RequestMapping("/")
public class PurseController {
    public static final String ALL_PURSE = "allPurse";
    public static final String ERROR_PAGE = "errorPage";
    public static final String SAVE_PURSE = "savePurse";
    public static final String PAGE_USER_SAVE_PURSE = "addPurseToUser";
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

    @RequestMapping(value = "/save/purse/{id}", method = RequestMethod.GET)
    public String showPageEditPurse(@PathVariable(value = "id") Long id, ModelMap model) {
        Purse purse = purseService.getById(id);
        if (purse == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("purseForm", new PurseForm(purse));
        model.addAttribute("ownerId", purse.getOwner().getId());
        model.addAttribute("currencies", currencyService.getAll());
        return SAVE_PURSE;
    }

    @RequestMapping(value = "/save/purse", method = RequestMethod.POST)
    public String savePurse(@Validated PurseForm purseForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("currencies", currencyService.getAll());
            return SAVE_PURSE;
        }
        User user = userService.getById(Long.parseLong(purseForm.getOwnerId()));
        Currency currency = currencyService.getById(Long.parseLong(purseForm.getCurrencyId()));
        Purse purse = new Purse(purseForm.getName(), currency, user, new BigDecimal(purseForm.getAmount()));
        purse.setId(Long.parseLong(purseForm.getId()));
        purseService.update(purse);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/save/purse/{id}", method = RequestMethod.GET)
    public String showPageAddPurseUser(@PathVariable(value = "id") Long id, ModelMap model) {
        User user = userService.getById(id);
        if (user == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("purseForm", new PurseForm());
        model.addAttribute("ownerId", user.getId());
        model.addAttribute("currencies", currencyService.getAll());
        return PAGE_USER_SAVE_PURSE;
    }

    @RequestMapping(value = "/user/save/purse/{id}", method = RequestMethod.POST)
    public String addPurseUser(@PathVariable(value = "id") Long id, @Validated PurseForm purseForm, BindingResult bindingResult, ModelMap model) {
        User user = userService.getById(id);
        if (bindingResult.hasErrors()) {
            if (user == null) {
                return ERROR_PAGE;
            }
            model.addAttribute("ownerId", user.getId());
            model.addAttribute("currencies", currencyService.getAll());
            return PAGE_USER_SAVE_PURSE;
        }
        Currency currency = currencyService.getById(Long.parseLong(purseForm.getCurrencyId()));
        purseService.insert(new Purse(purseForm.getName(), currency, user,
                new BigDecimal(purseForm.getAmount())));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id) {
        purseService.deleteById(id);
        return new RedirectView("/");
    }
}


