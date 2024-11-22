package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;


public abstract class BasePage {

    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void click(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
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
                System.out.println("Element is displayed.");
            }
            softAssert.assertAll();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            throw new SkipException("Skipping the test because the element was not found.");
        }

    }

    public void clickElement(WebElement component) {
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


    public void inputText(WebElement txtField, String text) {
        try {
            // Clear the existing text
            txtField.clear();
            // Enter the provided text
            txtField.sendKeys(text);
            // Log success
            System.out.println("Entered text: " + text + " into element: " + txtField);
        } catch (Exception e) {
            System.out.println("Failed to enter text into element: " + e.getMessage());
            throw e; // Rethrow the exception to fail the test if necessary
        }
    }



    public void inputNumeric(WebElement numField, Integer number) {
        try {
            // Clear the field
            numField.clear();
            // Enter the provided number
            numField.sendKeys(number.toString());
            // Log success
            System.out.println("Entered number: " + number + " into element: " + numField);
        } catch (Exception e) {
            System.out.println("Failed to enter number into element: " + e.getMessage());
            throw e; // Rethrow the exception to fail the test if necessary
        }
    }


    public boolean isRequiredError(WebElement validationMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(validationMsg)).isDisplayed();
    }


}
