package ru.jooble.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.jooble.controllers.forms.CurrencyForm;
import ru.jooble.controllers.validator.CurrencyFromValidator;
import ru.jooble.service.CurrencyService;
import ru.jooble.domain.Currency;


@Controller
public class CurrencyController {
    public static final String ALL_CURRENCY = "allCurrency";
    public static final String SAVE_CURRENCY = "saveCurrency";
    public static final String ERROR_PAGE = "errorPage";
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyFromValidator currencyFromValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(currencyFromValidator);
    }

    @RequestMapping(value = "/all/currency", method = RequestMethod.GET)
    public String showAllCurrency(ModelMap model) {
        model.addAttribute("currencies", currencyService.getAll());
        return ALL_CURRENCY;
    }

    @RequestMapping(value = "/save/currency", method = RequestMethod.GET)
    public String showPageAddCurrency(ModelMap model) {
        model.addAttribute("currencyForm", new CurrencyForm());
        return SAVE_CURRENCY;
    }

    @RequestMapping(value = "/save/currency/{id}", method = RequestMethod.GET)
    public String showPageEditCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        Currency currency = currencyService.getById(id);
        if (currency == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("currencyForm", new CurrencyForm(currency));
        return SAVE_CURRENCY;
    }

    @RequestMapping(value = "/save/currency", method = RequestMethod.POST)
    public String saveCurrency(@Validated CurrencyForm currencyForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return SAVE_CURRENCY;
        }
        if (currencyForm.getId().isEmpty()) {
            currencyService.insert(new Currency(0, currencyForm.getShortName()));
        } else {
            currencyService.update(new Currency(Integer.parseInt(currencyForm.getId()), currencyForm.getShortName()));
        }
        return "redirect:/all/currency";
    }

    @RequestMapping(value = "/delete/currency/{id}", method = RequestMethod.GET)
    public RedirectView deleteCurrency(@PathVariable(value = "id") Long id) {
        currencyService.deleteById(id);
        return new RedirectView("/all/currency");
    }
}

