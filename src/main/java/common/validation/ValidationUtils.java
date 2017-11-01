package common.validation;

import common.Form;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
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

    public static  <T extends Form> HttpServletRequest collectErrorMessages(HttpServletRequest request, Set<ConstraintViolation<T>> violations) {
        List<String> violationMessage = new ArrayList<>();
        for (ConstraintViolation constraintViolation : violations) {
            violationMessage.add(constraintViolation.getMessage());
        }
        request.setAttribute("errors", violationMessage);
        return request;
    }
}
