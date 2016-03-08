package ru.jooble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.jooble.domain.Currency;
import ru.jooble.service.CurrencyService;
import ru.jooble.service.CurrencyServiceJdbcImpl;

@Controller
@RequestMapping("/")
public class CurrencyController {

    @RequestMapping(value = "all/currency", method = RequestMethod.GET)
    public String allCurrency(ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("currency", currencyService.getAll());
        return "allCurrency";
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.GET)
    public String addCurrency(ModelMap model) {
        return "addCurrency";
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.POST)
    public RedirectView currencyInput(@RequestParam String addCurrencyName, ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        currencyService.insert(new Currency(0, addCurrencyName));
        return new RedirectView("/all/currency");
    }
}
