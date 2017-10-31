package common.validation;

import common.Form;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Author: sazal
 * Date: 10/31/17
 */
public class ValidationUtils {

    public static <T extends Form> Set<ConstraintViolation<T>> validateForm(T form) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator().validate(form);
    }
}
