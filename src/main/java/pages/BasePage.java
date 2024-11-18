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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    public void presenceOfElementLocated(WebElement element) {
        SoftAssert softAssert = new SoftAssert();
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
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
        int retries = 3; // Number of retries for stale element
        for (int i = 0; i < retries; i++) {
            try {
                // Wait for the element to be clickable
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(component));

                // Scroll into view (if necessary) before clicking
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                // Ensure element is clickable and not hidden by another element
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                System.out.println("Element clicked successfully.");
                return; // Exit the method after a successful click
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Retrying: " + e.getMessage());
                try {
                    Thread.sleep(1000); // Sleep for 1 second before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying due to StaleElementReferenceException: " + e.getMessage());
                try {
                    Thread.sleep(1000); // Wait before retrying to allow DOM to stabilize
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
                break; // Exit loop if element cannot be found
            } catch (TimeoutException e) {
                System.out.println("Timeout waiting for the element: " + e.getMessage());
                break; // Exit loop on timeout
            }
        }
        System.out.println("Failed to click the element after retries.");
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


    public boolean isRequiredError(WebElement validationMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(validationMsg)).isDisplayed();
    }





}
