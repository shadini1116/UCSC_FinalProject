package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;
import pages.PageFactory;
import utils.Drivers;

public class AppointmentTest extends BaseTest {


    @Test
    public void testLocation() {
        PageFactory.homePage.validateLocation();
    }

    @Test(dependsOnMethods = "testLocation")
    public void setLocation() {
        PageFactory.homePage.clickOnDefaultLocation();
    }

    @Test(priority = 1)
    public void verifyAppointmentIcon() {
        PageFactory.homePage.checkAppointmentIcon();
    }

    @Test(dependsOnMethods = "verifyAppointmentIcon")
    public void goToTheAppointmentPage(){
        PageFactory.homePage.clickOnAppointments();
    }

    @Test(dependsOnMethods = "goToTheAppointmentPage")
    public void addNewAppointment() {

        // Initialize the AppointmentPage (Login is handled in BaseTest's setup)
        //AppointmentPage appointmentPage = new AppointmentPage(Drivers.getDriver());

        // Click the "New Appointment" button
        PageFactory.appointmentPage.clickNewAppointment();

        // Fill out the appointment form with all required details
        PageFactory.appointmentPage.fillAppointmentForm(
                "2024-11-12 10:00 AM", // Appointment Start
                "11:00 AM",            // Appointment End
                "John Doe",            // Appointment For Person
                "Consultation",        // Category
                "Follow-up discussion" // Notes
        );

        // Submit the appointment form
        PageFactory.appointmentPage.submitAppointment();

        // Add assertions to verify if the appointment was added successfully
        System.out.println("New appointment has been added successfully!");
    }

    @Test(dependsOnMethods = "addNewAppointment")
    public void SearchAppointmentById() {
        AppointmentPage appointmentPage = new AppointmentPage(driver);

        // Search for a specific appointment ID
        String appointmentId = "12345";
        appointmentPage.searchAppointmentById(appointmentId);

        // Assert that the appointment is displayed
        Assert.assertTrue(appointmentPage.isAppointmentDisplayed(), "Appointment not found!");
        System.out.println("Appointment with ID " + appointmentId + " is displayed.");
    }
}
