package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.PageFactory;

public class Drivers{
    //Reading browser from the property file
    private static final String browser = PropertyFileReader.getProperty("src/main/resources/config.properties", "browser");
    private static WebDriver driver;

    private static void setDrivers() {
        if (driver == null) {
            switch (browser.toUpperCase()) {
                case "CHROME":
                    driver = WebDriverManager.chromedriver().create();
                    break;
                case "FIREFOX":
                    driver = WebDriverManager.firefoxdriver().create();
                    break;
                default:
                    driver = WebDriverManager.chromedriver().create();
                    break;
            }
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setDrivers();
        }
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
