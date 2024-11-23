package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarPage extends AppointmentPage {

    @FindBy(id = "") // Verify this ID in your HTML
    private WebElement addNewAppointmentButton;

    /*
    @FindBy(xpath = "//table[@id='calendar_appointments']//tr") // Verify this XPath
    private WebElement calendarAppointments;*/

    public CalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public AppointmentPage clickAddNewAppointment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addNewAppointmentButton)).click();
        return new AppointmentPage(driver); // Returns the appointment page
    }


    /*public boolean areAppointmentsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(calendarAppointments)).isDisplayed();
    }*/
}

