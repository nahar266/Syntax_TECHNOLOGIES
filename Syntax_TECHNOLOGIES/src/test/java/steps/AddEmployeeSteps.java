package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonMethods;
import java.io.IOException;


public class AddEmployeeSteps extends CommonMethods {

    @Given("Admin is able to access HRMS application")
    public void admin_is_able_to_access_hrms_application() throws IOException {
        invokeBrowserAndOpenURL();
    }

    @When("Admin enters valid username and password")
    public void admin_enters_valid_username_and_password() {
        sendText(loginPage.usernameField, "admin");
        sendText(loginPage.passwordField, "Hum@nhrm123");
    }

    @And("Admin clicks on login button")
    public void admin_clicks_on_login_button() {
        loginPage.loginBtn.click();
    }

    @And("Admin is successfully logged in")
    public void admin_is_successfully_logged_in() {
        String expectedMessage = loginPage.welcomeMsg.getText();
        String actualMessage = "Welcome Admin";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("Admin clicks on PIM option")
    public void admin_clicks_on_pim_option() {
        elementClick(dashboardPage.pimBtn);
        waitTime();
    }

    @And("Admin clicks on Add Employee option")
    public void admin_clicks_on_add_employee_option() {
        elementClick(dashboardPage.addEmployeeBtn);
        waitTime();
    }

    @And("Admin enters First Name and Last Name")
    public void admin_enters_first_name_and_last_name() {
        waitTime();
        System.out.println("firstname");
      sendText(addEmployeePage.firstName, "Jack");
      sendText(addEmployeePage.lastName, " Smith");
    }

    @Then("Admin submit the form without providing Employee ID")
    public void admin_submit_the_form_without_providing_employee_id() {
       addEmployeePage.addEmployeeID.clear();
    }

//    @Then("Admin Clicks on save button")
//    public void admin_clicks_on_save_button() {
//        elementClick(addEmployeePage.saveBtn);
//    }

    @Given("Admin clicks on Add Employee option on the {string}")
    public void admin_clicks_on_add_employee_option_on_the(String btn) {
       elementClick(dashboardPage.addEmployeeBtn);

    }

    @When("Admin enters {string} as First Name and {string} as Last Name")
    public void admin_enters_as_first_name_and_as_last_name(String firstName, String lastName) {
        addEmployeePage.firstName.clear();
        sendText(addEmployeePage.firstName, "John");
        addEmployeePage.lastName.clear();
        sendText(addEmployeePage.lastName, "Doe");
    }

    @When("Admin enters {string} as Employee ID")
    public void admin_enters_as_employee_id(String string) {
        addEmployeePage.addEmployeeID.clear();
        sendText(addEmployeePage.addEmployeeID, "EMP0099");
    }


  @When("Admin clicks on save button")
    public void admin_clicks_on_save_button() {
        elementClick(addEmployeePage.saveBtn);
    }

    @Then("The employee should be added successfully with Employee ID {string}")
    public void the_emolpyee_should_be_added_successfully_with_employee_id(String expectedId) {
      String actualId = addEmployeePage.confirmPage.getAttribute("value");
      Assert.assertEquals("Employee ID match", expectedId, actualId);

    }


}
