package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

