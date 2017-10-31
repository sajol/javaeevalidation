package servlet;

import common.Form;
import common.FormUtils;
import common.validation.ValidationUtils;
import form.MyForm;
import org.apache.commons.collections.CollectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: sazal
 * Date: 10/30/17
 */
@WebServlet(
        name = "ExampleValidationServlet",
        description = "An improved example servlet",
        urlPatterns = {"/example-improved"}
)
public class ExampleValidationServletImproved extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<ConstraintViolation<MyForm>> violations = ValidationUtils.validateForm(FormUtils.getForm(request, MyForm.class));
        if (CollectionUtils.isEmpty(violations)) {
            String responseBody = "Hello I Am An Improved Example Servlet\nYour form was saved successfully";
            response.getWriter().write(responseBody);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(collectErrorMessages(request, violations), response);
        }
    }

    private <T extends Form> HttpServletRequest collectErrorMessages(HttpServletRequest request, Set<ConstraintViolation<T>> violations) {
        List<String> violationMessage = new ArrayList<>();
        for (ConstraintViolation constraintViolation : violations) {
            violationMessage.add(constraintViolation.getMessage());
        }
        request.setAttribute("errors", violationMessage);
        return request;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
