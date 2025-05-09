package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import java.io.IOException;


public class loginSteps extends CommonMethods {
    @Given("User is able to access to HRMS application")
    public void user_is_able_to_access_to_hrms_application() throws IOException {
        invokeBrowserAndOpenURL();
    }
    @When("User leave empty username field")
    public void user_leave_empty_username_field() {
        sendText(loginPage.usernameField, "");
    }
    @And("User enter password")
    public void user_enter_password() {
        sendText(loginPage.passwordField, "Hum@nhrm123");
    }
    @And("User click on login button")
    public void user_click_on_login_button() {
        elementClick(loginPage.loginBtn);
    }
    @Then("User able to see error message {string}")
    public void userAbleToSeeErrorMessage(String arg0) {
        String expectedMessage = loginPage.errorMessage.getText();
        String actualMessage = "Username cannot be empty";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("User enter username")
    public void user_enter_username() {
        sendText(loginPage.usernameField, "admin");
    }
    @And("User leave empty password field")
    public void user_leave_empty_password_field() {
        sendText(loginPage.passwordField, "");
    }
    @Then("User able to see error message \\{string} {string}")
    public void userAbleToSeeErrorMessageString(String pwd) {
        String expectedMessage = loginPage.errorMessage.getText();
        String actualMessage = "Password is Empty";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("User enter invalid username and invalid password")
    public void user_enter_invalid_username_and_invalid_password() {
        sendText(loginPage.usernameField, "admn");
        sendText(loginPage.passwordField, "humn");
    }
    @Then("User able to see {string}")
    public void userAbleToSee(String arg0) {
        String expectedMessage = loginPage.errorMessage.getText();
        String actualMessage = "Invalid credentials";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("User enters invalid username")
    public void userEntersInvalidUsername() {
        sendText(loginPage.usernameField, "admn");
    }
    @And("User enters invalid password")
    public void userEntersInvalidPassword() {
        sendText(loginPage.passwordField, "humn");
    }
    @And("User clicks the login button")
    public void user_clicks_the_login_button() {
       loginPage.loginBtn.click();
    }
    @And("User should see error message {string} near the login form")
    public void user_should_see_error_message_near_the_login_form(String string) {
        String expectedMessage = loginPage.errorMessage.getText();
        String actualMessage = "Invalid credentials";
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @And("User clears the login form")
    public void user_clears_the_login_form() {
        loginPage.usernameField.clear();
        loginPage.passwordField.clear();
    }
    @And("User enters valid username into the username field")
    public void userEntersValidUsernameIntoTheUsernameField() {
        sendText(loginPage.usernameField, "admin");
    }
    @And("User enters valid password into the password field")
    public void userEntersValidPasswordIntoThePasswordField() {
        sendText(loginPage.passwordField, "Hum@nhrm123");
    }
    @And("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        loginPage.loginBtn.click();
    }
    @Then("User should see {string} message on the homepage")
    public void user_should_see_message_on_the_homepage(String string) {
       String expectedMessage = loginPage.welcomeMsg.getText();
       String actualMessage = "Welcome Admin";
       Assert.assertEquals(expectedMessage, actualMessage);
    }


}