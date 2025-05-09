package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Point;
import utils.CommonMethods;



public class AddEmployeeErrorMessaeValidationSteps extends CommonMethods {

    @When("Admin leaves the First Name field blank")
    public void admin_leaves_the_first_name_field_blank() {
        sendText(addEmployeePage.firstName, "");
    }
    @And("Admin enters {string} as Last Name")
    public void admin_enters_as_last_name(String string) {
        sendText(addEmployeePage.lastName, "Smith");
    }
    @Then("The system should display a clear error message for the First Name field")
    public void the_system_should_display_a_clear_error_message_for_the_first_name_field() {
        addEmployeeErrorMessageValidationPage.firstNameErrorMsg.getAttribute("Required");
    }
    @And("The error message should be visible and placed near the First Name field")
    public void the_error_message_should_be_visible_and_placed_near_the_first_name_field() {
        Assert.assertTrue("Error Message should be vissible",addEmployeeErrorMessageValidationPage.firstNameErrorMsg.isDisplayed());

       Point inputLoication = addEmployeePage.firstName.getLocation();
        Point errorMessageLoication = addEmployeeErrorMessageValidationPage.firstNameErrorMsg.getLocation();

        int verticleDistance = Math.abs(inputLoication.getY() - errorMessageLoication.getY());
        Assert.assertTrue("Error Message is in the correct position", verticleDistance < 100);
    }

    @When("Admin enters {string} as First Name")
    public void admin_enters_as_first_name(String string) {
        sendText(addEmployeePage.firstName, "Mike");
    }
    @When("Admin leaves the Last Name field blank")
    public void admin_leaves_the_last_name_field_blank() {
        sendText(addEmployeePage.lastName, "");
    }
    @Then("The system should display a clear error message for the Last Name field")
    public void the_system_should_display_a_clear_error_message_for_the_last_name_field() {
        addEmployeeErrorMessageValidationPage.lastNameErrorMsg.getAttribute("Required");
    }
    @Then("The error message should be visible and placed near the Last Name field")
    public void the_error_message_should_be_visible_and_placed_near_the_last_name_field() {
        Assert.assertTrue("Error Message should be vissible",addEmployeeErrorMessageValidationPage.lastNameErrorMsg.isDisplayed());

        Point inputLoication = addEmployeePage.lastName.getLocation();
        Point errorMessageLoication = addEmployeeErrorMessageValidationPage.lastNameErrorMsg.getLocation();

        int verticleDistance = Math.abs(inputLoication.getY() - errorMessageLoication.getY());
        Assert.assertTrue("Error Message is in the correct position", verticleDistance < 100);
    }

    @Then("The system should display clear error messages for the required fields")
    public void the_system_should_display_clear_error_messages_for_the_required_fields() {
        String extectedFirstNameError = "Required";
       String actualFirstNameError = addEmployeeErrorMessageValidationPage.firstNameErrorMsg.getText();

        String extectedLastNameError = "Required";
        String actualLastNameError = addEmployeeErrorMessageValidationPage.lastNameErrorMsg.getText();

        Assert.assertEquals("First Name Error Message",extectedFirstNameError, actualFirstNameError );
        Assert.assertEquals("Last Name Error Message",extectedLastNameError, actualLastNameError );
    }
    @Then("The error messages should be visible and placed near their respective fields")
    public void the_error_messages_should_be_visible_and_placed_near_their_respective_fields() {
        Assert.assertTrue("First Name Error Message Should be Visible", addEmployeeErrorMessageValidationPage.firstNameErrorMsg.isDisplayed());
        Assert.assertTrue("Last Name Error Message Should be Visible", addEmployeeErrorMessageValidationPage.lastNameErrorMsg.isDisplayed());

        Point firstNameLocation = addEmployeePage.firstName.getLocation();
        Point firstNameErrorMsgLocation = addEmployeeErrorMessageValidationPage.firstNameErrorMsg.getLocation();
        int firstNameDistance = Math.abs(firstNameLocation.getY()- firstNameErrorMsgLocation.getY());
        Assert.assertTrue("Error Message is in the correct position", firstNameDistance < 100);


        Point lastNameLocation = addEmployeePage.lastName.getLocation();
        Point lastNameErrorMsgLocation = addEmployeeErrorMessageValidationPage.lastNameErrorMsg.getLocation();
        int lastNameDistance = Math.abs(lastNameLocation.getY()- lastNameErrorMsgLocation.getY());
        Assert.assertTrue("Error Message is in the correct position", lastNameDistance < 100);
    }


}
