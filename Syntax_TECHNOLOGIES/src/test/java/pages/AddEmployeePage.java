package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {



    @FindBy(id="firstName")
   public WebElement firstName;

    @FindBy(id="lastName")
   public WebElement lastName;

    @FindBy(id="employeeId")
   public WebElement addEmployeeID;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy(id="personal_txtEmployeeId")
    public WebElement confirmPage;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
