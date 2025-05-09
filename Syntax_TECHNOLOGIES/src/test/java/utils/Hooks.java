package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Hooks extends CommonMethods{


    @Before
    public void browserSetUp() throws IOException {
        invokeBrowserAndOpenURL();
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
