package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeBtn;

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }
}
