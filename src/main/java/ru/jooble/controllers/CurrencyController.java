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
import ru.jooble.controllers.forms.CurrencyForm;
import ru.jooble.controllers.validator.CurrencyFromValidator;
import ru.jooble.domain.Currency;
import ru.jooble.service.CurrencyService;


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
    public String saveCurrency(@Validated CurrencyForm currencyForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_CURRENCY;
        }
        if (currencyForm.getId().isEmpty()) {
            Currency currency = getCurrency(currencyForm);
            currencyService.insert(currency);
        } else {
            Currency currency = getCurrency(currencyForm);
            currency.setId(Long.parseLong(currencyForm.getId()));
            currencyService.update(currency);
        }
        return "redirect:/all/currency";
    }

    private Currency getCurrency(@Validated CurrencyForm currencyForm) {
        Currency currency = new Currency();
        currency.setName(currencyForm.getShortName());
        return currency;
    }

    @RequestMapping(value = "/delete/currency/{id}", method = RequestMethod.GET)
    public String deleteCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        try {
            currencyService.deleteById(id);
            return "redirect:/all/currency";
        } catch (Exception e) {
            model.addAttribute("error", "Can`t delete by Currency");
            return ERROR_PAGE;
        }
    }
}

