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
import ru.jooble.DTO.CurrencyDTO;
import ru.jooble.controllers.forms.CurrencyForm;
import ru.jooble.controllers.validator.CurrencyFromValidator;
import ru.jooble.service.CurrencyService;


@Controller
public class CurrencyController {
    private static final String ALL_CURRENCY = "allCurrency";
    private static final String SAVE_CURRENCY = "saveCurrency";
    private static final String ERROR_PAGE = "errorPage";
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
        try {
            CurrencyDTO currencyDTO = currencyService.getById(id);
            model.addAttribute("currencyForm", new CurrencyForm(currencyDTO));
            return SAVE_CURRENCY;
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = "/save/currency", method = RequestMethod.POST)
    public String saveCurrency(@Validated CurrencyForm currencyForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_CURRENCY;
        }
        if ("".equals(currencyForm.getId())) {
            CurrencyDTO currencyDTO = getCurrencyDTO(currencyForm);
            currencyService.insert(currencyDTO);
        } else {
            CurrencyDTO currencyDTO = getCurrencyDTO(currencyForm);
            currencyDTO.setId(currencyForm.getId());
            currencyService.update(currencyDTO);
        }
        return "redirect:/all/currency";
    }

    private CurrencyDTO getCurrencyDTO(@Validated CurrencyForm currencyForm) {
        CurrencyDTO currencyDTO = new CurrencyDTO();
        currencyDTO.setName(currencyForm.getShortName());
        return currencyDTO;
    }

    @RequestMapping(value = "/delete/currency/{id}", method = RequestMethod.POST)
    public String deleteCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        currencyService.deleteById(id);
        return "redirect:/all/currency";
    }

    @RequestMapping(value = "/all/currency/search/{criteria}", method = RequestMethod.GET)
    public String searchCurrency(@PathVariable(value = "criteria") String criteria, ModelMap model) {
        model.addAttribute("currencies", currencyService.getByCriteria(criteria));
        return "tableAllCurrency";
    }
}


