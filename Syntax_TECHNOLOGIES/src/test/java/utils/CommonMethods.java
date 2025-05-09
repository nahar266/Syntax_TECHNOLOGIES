package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class CommonMethods extends PageObjectInitializer {

    public static WebDriver driver;

    public void invokeBrowserAndOpenURL() throws IOException {

        switch (ConfigReader.read("browser")){
            case  "Chrome":
                driver = new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.read("url"));
        initializeObject();
    }

    public void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

    public void sendText(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }

    public WebDriverWait waitTime(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void elementToBeClickable(WebElement element){
        waitTime().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementClick(WebElement element){
        elementToBeClickable(element);
        element.click();
    }
}
