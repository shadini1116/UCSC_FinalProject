package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Drivers;

public class PageFactory extends org.openqa.selenium.support.PageFactory {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static CustomerPage customerPage;
    public static SupplierPage supplierPage;

    public static void init(WebDriver driver) {
        loginPage = initElements(driver, LoginPage.class);
        homePage = initElements(driver, HomePage.class);
        customerPage = initElements(driver,CustomerPage.class);
        supplierPage = initElements(driver, SupplierPage.class);
    }
}
