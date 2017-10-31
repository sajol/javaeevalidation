package form;

import common.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Author: sazal
 * Date: 10/27/17
 */
public class MyForm implements Form{

    @NotNull(message = "First name is null")
    @NotEmpty(message = "First name is empty")
    private String firstName;

    @NotNull(message = "Last name is null")
    @NotEmpty(message = "Last name is empty")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
