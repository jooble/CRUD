package ru.jooble.controllers.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.jooble.controllers.forms.PurseForm;

import java.math.BigDecimal;

@Component
public class PurseFromValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PurseForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.purseName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "valid.purseAmount.empty");
        PurseForm message = (PurseForm) target;
        if (message.getName().length() < 2 || message.getName().length() > 10) {
            errors.rejectValue("name", "valid.purseName.length");
        }
        try {
            new BigDecimal(message.getAmount());
        } catch (Exception e) {
            errors.rejectValue("amount", "valid.purseAmount.notNumber");
        }
    }
}


