package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboardLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void validateTheTitle(){
        presenceOfElementLocated(dashboardLabel);


    }

    @FindBy(xpath = "//span[@class='text' and text()='Appointments']/parent::a")
    private WebElement appointmentsIcon;

    public void clickOnAppointments(){
        click(appointmentsIcon);


    }
    public void checkAppointmentIcon(){
        presenceOfElementLocated(appointmentsIcon);
    }
    @FindBy(xpath = "//a[@class='set_employee_current_location_after_login' and @href='https://demo.phppointofsale.com/index.php/home/set_employee_current_location_id/1']")
    private WebElement defaultLocation;

    public void validateLocation(){
        presenceOfElementLocated(defaultLocation);
    }

    public void clickOnDefaultLocation() {
        click(defaultLocation);
    }



}


