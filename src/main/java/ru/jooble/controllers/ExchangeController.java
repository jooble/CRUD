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
import ru.jooble.DTO.CurrencyDTO;
import ru.jooble.DTO.ExchangeDTO;
import ru.jooble.controllers.forms.ExchangeForm;
import ru.jooble.controllers.validator.ExchangeFromValidator;
import ru.jooble.service.CurrencyService;
import ru.jooble.service.ExchangeService;

import java.util.List;

@Controller
public class ExchangeController {
    private static final String ERROR_PAGE = "errorPage";
    private static final String SAVE_EXCHANGE = "saveExchange";

    @Autowired
    ExchangeService exchangeService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    ExchangeFromValidator exchangeFromValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(exchangeFromValidator);
    }


    @RequestMapping(value = "/all/exchange", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {
        model.addAttribute("exchanges", exchangeService.getAll());
        return "allExchange";
    }

    @RequestMapping(value = "/save/exchange", method = RequestMethod.GET)
    public String showPageAddExchange(ModelMap model) {
        List<CurrencyDTO> currencyDTOs = currencyService.getAll();
        model.addAttribute("exchangeForm", new ExchangeForm());
        model.addAttribute("sourceCurrencies", currencyDTOs);
        model.addAttribute("targetCurrencies", currencyDTOs);
        return SAVE_EXCHANGE;
    }

    @RequestMapping(value = "/save/exchange/{id}", method = RequestMethod.GET)
    public String showPageEditExchange(@PathVariable(value = "id") Long id, ModelMap model) {
        try {
            ExchangeDTO exchangeDTO = exchangeService.getById(id);
            List<CurrencyDTO> currencyDTOs = currencyService.getAll();
            model.addAttribute("exchangeForm", new ExchangeForm(exchangeDTO));
            model.addAttribute("sourceCurrencies", currencyDTOs);
            model.addAttribute("targetCurrencies", currencyDTOs);
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
        return SAVE_EXCHANGE;
    }

    @RequestMapping(value = "/save/exchange", method = RequestMethod.POST)
    public String saveExchange(@Validated ExchangeForm exchangeForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            List<CurrencyDTO> currencyDTOs = currencyService.getAll();
            model.addAttribute("sourceCurrencies", currencyDTOs);
            model.addAttribute("targetCurrencies", currencyDTOs);
            return SAVE_EXCHANGE;
        }
        CurrencyDTO sorceCurrency = currencyService.getById(Long.parseLong(exchangeForm.getSourceCurrencyId()));
        CurrencyDTO targetCurrency = currencyService.getById(Long.parseLong(exchangeForm.getTargetCurrencyId()));
        if ("".equals(exchangeForm.getId())) {
            ExchangeDTO exchangeDTO = getExchangeDTO(exchangeForm, sorceCurrency, targetCurrency);
            exchangeService.insert(exchangeDTO);
        } else {
            ExchangeDTO exchangeDTO = getExchangeDTO(exchangeForm, sorceCurrency, targetCurrency);
            exchangeDTO.setId(exchangeForm.getId());
            exchangeService.update(exchangeDTO);
        }
        return "redirect:/all/exchange";
    }

    private ExchangeDTO getExchangeDTO(@Validated ExchangeForm exchangeForm, CurrencyDTO sorceCurrency, CurrencyDTO targetCurrency) {
        ExchangeDTO exchangeDTO = new ExchangeDTO();
        exchangeDTO.setSourceCurrency(sorceCurrency);
        exchangeDTO.setTargetCurrency(targetCurrency);
        exchangeDTO.setExchangeRate(exchangeForm.getExchangeRate());
        return exchangeDTO;
    }

    @RequestMapping(value = "/delete/exchange/{id}", method = RequestMethod.GET)
    public RedirectView deleteExchange(@PathVariable(value = "id") Long id) {
        exchangeService.deleteById(id);
        return new RedirectView("/all/exchange");
    }
}
