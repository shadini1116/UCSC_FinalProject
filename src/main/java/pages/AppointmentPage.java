package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentPage extends BasePage {

//    public AppointmentPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }

    // Locators for the form fields
    @FindBy(xpath = "//*[contains(@class,'btn btn-primary btn-lg hidden-sm hidden-xs')]")
    private WebElement newAppointmentButton;

    @FindBy(xpath = "//input[@class='form-control form-inps datepicker']")
    private WebElement appointmentStart;

    @FindBy(xpath = "//input[@id='end_time']")
    private WebElement appointmentEnd;

    @FindBy(xpath = "//input[@id='choose_person']")
    private WebElement appointmentForPerson;

    @FindBy(xpath = "//select[@id='employee_id']")
    private WebElement employeeDropdown;


    @FindBy(xpath = "//div[@class='selectize-input items not-full']/input")
    private WebElement category;

    @FindBy(xpath = "//textarea[@class='form-control text-area']")
    private WebElement notes;

    @FindBy(xpath = "//input[@id='submitf']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@class='form-control ui-autocomplete-input']")
    private WebElement searchAppointmentField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@id='appointment_table']//tr[1]")
    private WebElement searchResult;


   /* @FindBy(xpath = "//span[@class='ion-calendar']")
    private WebElement calendarIcon;

    public CalendarPage navigateToCalendarPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();
        return new CalendarPage(driver); // Returns the CalendarPage
    }*/



    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    // Method to click the "New Appointment" button to open the form
//    public void clickNewAppointment() {
//        newAppointmentButton.click();
//    }


    public void clickNewAppointment(){
        click(newAppointmentButton);
    }

    // Method to fill out the appointment form
    public void fillAppointmentForm(String startDateTime, String endTime, String person, String categoryName, String notesText) {
        appointmentStart.sendKeys(startDateTime); // Enter start date and time
        appointmentEnd.sendKeys(endTime); // Enter end time
        appointmentForPerson.sendKeys(person); // Enter person's name


        // Select an employee from the dropdown
        Select employeeSelect = new Select(employeeDropdown);
        employeeSelect.selectByVisibleText("John Doe"); // Use the employee name as displayed in the dropdown

        category.sendKeys(categoryName); // Enter category
        notes.sendKeys(notesText); // Enter notes
    }

    // Method to submit the appointment form
    public void submitAppointment() {
        submitButton.click();
    }

    /*public void searchAppointmentById(String appointmentId) {
        //searchAppointmentField.clear();
        searchAppointmentField.sendKeys(appointmentId);
        searchButton.click();
    }*/

    public void searchAppointmentById(String appointmentId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchAppointmentField)).sendKeys(appointmentId);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }


    public boolean isAppointmentDisplayed() {
        return searchResult.isDisplayed();
    }


}

