package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public abstract class BasePage {

    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void click(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    public void presenceOfElementLocated(WebElement element) {
        SoftAssert softAssert = new SoftAssert();
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                softAssert.assertTrue(true);
            }
            softAssert.assertAll();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

}
