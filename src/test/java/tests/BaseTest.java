package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.PageFactory;
import utils.Drivers;

public class BaseTest {
    WebDriver driver = Drivers.getDriver();

    @BeforeMethod
    public void setUp() {
        driver = Drivers.getDriver();
        PageFactory.init(driver);
        PageFactory.loginPage.initApp();
        PageFactory.loginPage.clickLoginButton();
    }


}

