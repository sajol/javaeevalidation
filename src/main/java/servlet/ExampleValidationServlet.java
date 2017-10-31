package servlet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: sazal
 * Date: 10/27/17
 */
@WebServlet(
        name = "ExampleValidationServlet",
        description = "An example servlet",
        urlPatterns = {"/example"}
)
public class ExampleValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        List<String> validationErrors = new ArrayList<>();
        if(StringUtils.isBlank(firstName)){
            validationErrors.add("First name should not be empty");
        }
        if(StringUtils.isBlank(lastName)){
            validationErrors.add("Last name should not be empty");
        }

        if(CollectionUtils.isNotEmpty(validationErrors)){
            request.setAttribute("errors", validationErrors);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        String responseBody = "Hello I Am An Example Servlet\n" +
                "Your inputs were\n" +
                "First name : " + firstName + "\n" +
                "Last name: " + lastName + "\n";
        response.getWriter().write(responseBody);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
