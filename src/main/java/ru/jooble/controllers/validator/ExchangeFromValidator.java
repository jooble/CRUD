package ru.jooble.controllers.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.jooble.controllers.forms.ExchangeForm;

@Component
public class ExchangeFromValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ExchangeForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exchangeRate", "valid.exchangeRate.empty");
        ExchangeForm message = (ExchangeForm) target;
        try {
            Double.parseDouble(message.getExchangeRate());
        } catch (Exception e) {
            errors.rejectValue("exchangeRate", "valid.exchangeRate.notNumber");
        }
    }
}
