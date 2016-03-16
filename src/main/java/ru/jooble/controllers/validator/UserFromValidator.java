package ru.jooble.controllers.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.jooble.controllers.forms.UserForm;

@Component
public class UserFromValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "valid.userFirstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "valid.userLastName.empty");
        UserForm message = (UserForm) target;
        if (message.getFirstName().length() < 3 || message.getFirstName().length() > 20) {
            errors.rejectValue("firstName", "valid.userFirstName.length");
        }
        if (message.getLastName().length() < 5 || message.getLastName().length() > 20) {
            errors.rejectValue("lastName", "valid.userLastName.length");
        }
    }
}
