package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;

public class AddEmployeeErrorMessageValidationPage {

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement firstNameErrorMsg;

    @FindBy(xpath = "//span[@for='lastName']")
    public WebElement lastNameErrorMsg;

    public AddEmployeeErrorMessageValidationPage(){
        PageFactory.initElements(driver, this);
    }
}
