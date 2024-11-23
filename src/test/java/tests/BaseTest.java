package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CustomerPage;
import pages.PageFactory;
import utils.Drivers;

public class BaseTest {
    WebDriver driver = Drivers.getDriver();

    @BeforeTest
    public void setUp() {
        driver = Drivers.getDriver();
        PageFactory.init(driver);
        PageFactory.loginPage.initApp();
        PageFactory.loginPage.clickLoginButton();

    }




}

