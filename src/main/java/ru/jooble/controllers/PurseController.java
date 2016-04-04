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
import ru.jooble.DTO.PurseDTO;
import ru.jooble.DTO.UserDTO;
import ru.jooble.controllers.forms.PurseForm;
import ru.jooble.controllers.validator.PurseFromValidator;
import ru.jooble.service.CurrencyService;
import ru.jooble.service.PurseService;
import ru.jooble.service.UserService;


@Controller
@RequestMapping("/")
public class PurseController {
    private static final String ALL_PURSE = "allPurse";
    private static final String ERROR_PAGE = "errorPage";
    private static final String SAVE_PURSE = "savePurse";
    private static final String PAGE_USER_SAVE_PURSE = "addPurseToUser";
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
        try {
            PurseDTO purseDTO = purseService.getById(id);
            model.addAttribute("purseForm", new PurseForm(purseDTO));
            model.addAttribute("ownerId", purseDTO.getOwnerDTO().getId());
            model.addAttribute("currencies", currencyService.getAll());
            return SAVE_PURSE;
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = "/save/purse", method = RequestMethod.POST)
    public String savePurse(@Validated PurseForm purseForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("currencies", currencyService.getAll());
            return SAVE_PURSE;
        }
        UserDTO userDTO = userService.getById(Long.parseLong(purseForm.getOwnerId()));
        CurrencyDTO currencyDTO = currencyService.getById(Long.parseLong(purseForm.getCurrencyId()));
        PurseDTO purseDTO = new PurseDTO();
        purseDTO.setName(purseForm.getName());
        purseDTO.setCurrencyDTO(currencyDTO);
        purseDTO.setOwnerDTO(userDTO);
        purseDTO.setAmount(purseForm.getAmount());
        purseDTO.setId(purseForm.getId());
        purseService.update(purseDTO);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/save/purse/{id}", method = RequestMethod.GET)
    public String showPageAddPurseUser(@PathVariable(value = "id") Long id, ModelMap model) {
        UserDTO userDTO = userService.getById(id);
        if (userDTO == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("purseForm", new PurseForm());
        model.addAttribute("ownerId", userDTO.getId());
        model.addAttribute("currencies", currencyService.getAll());
        return PAGE_USER_SAVE_PURSE;
    }

    @RequestMapping(value = "/user/save/purse/{id}", method = RequestMethod.POST)
    public String addPurseUser(@PathVariable(value = "id") Long id, @Validated PurseForm purseForm, BindingResult bindingResult, ModelMap model) {
        UserDTO userDTO = userService.getById(id);
        if (bindingResult.hasErrors()) {
            if (userDTO == null) {
                return ERROR_PAGE;
            }
            model.addAttribute("ownerId", userDTO.getId());
            model.addAttribute("currencies", currencyService.getAll());
            return PAGE_USER_SAVE_PURSE;
        }
        CurrencyDTO currencyDTO = currencyService.getById(Long.parseLong(purseForm.getCurrencyId()));
        PurseDTO purseDTO = new PurseDTO();
        purseDTO.setName(purseForm.getName());
        purseDTO.setCurrencyDTO(currencyDTO);
        purseDTO.setOwnerDTO(userDTO);
        purseDTO.setAmount(purseForm.getAmount());
        purseService.insert(purseDTO);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id) {
        purseService.deleteById(id);
        return new RedirectView("/");
    }
}


