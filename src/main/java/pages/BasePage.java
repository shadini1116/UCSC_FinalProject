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


    /*public void click(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }*/

    public void click(WebElement component) {
        int retries = 3;  // Number of retries
        for (int i = 0; i < retries; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.elementToBeClickable(component));

                // Scroll into view to ensure visibility
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", component);

                // Try a normal click first
                component.click();
                System.out.println("Element clicked successfully.");
                return;  // Exit method if successful

            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Trying JavaScript click: " + e.getMessage());
                // Try clicking using JavaScript if intercepted
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", component);

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element detected. Retrying: " + e.getMessage());
// Re-locate the element and retry
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
                break;
            } catch (TimeoutException e) {
                System.out.println("Timeout waiting for the element: " + e.getMessage());
                break;
            }
        }
        throw new RuntimeException("Failed to click the element after multiple retries.");
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
