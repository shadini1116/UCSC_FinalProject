package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Drivers;

public class PageFactory extends org.openqa.selenium.support.PageFactory {

    public static LoginPage loginPage;
    public static HomePage homePage;

    public static AppointmentPage appointmentPage;

    public static void init(WebDriver driver) {
        loginPage = initElements(driver, LoginPage.class);
        homePage = initElements(driver, HomePage.class);
        appointmentPage = initElements(driver, AppointmentPage.class);
    }
}
