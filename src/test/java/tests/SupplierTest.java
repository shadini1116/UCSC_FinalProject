package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static pages.PageFactory.supplierPage;

public class SupplierTest extends BaseTest {
    @Test
    public void testSupplier() {
        WebElement locationDefault = driver.findElement(By.xpath("//*[@id=\"choose_location_modal\"]/div/div/div[2]/ul/li[1]/a"));
        locationDefault.click();
        supplierPage.ignoreLocation();
        supplierPage.visitSupplierPage();
        //  PageFactory.supplierPage.addNewSupplier();
    }

    @Test
    public void testSupplierPageFeature() throws InterruptedException {
        supplierPage.visitSupplierPage();
        supplierPage.addNewSupplier("ABCDE",
                "Nishanya",
                "Shelani",
                "nishanyashelanii@gmail.com",
                "0769119963",
                "C:\\Users\\nisha\\IdeaProjects\\Selenium\\USCS_QA_POS\\UCSC_FinalProject\\src\\main\\resources\\avatar.png",
                "No.621/5/2",
                "St.Sebastian Road",
                "Ragama",
                "Western Province",
                "10100",
                "Sri Lanka",
                "Comment1",
                "Note1",
                "1234567899"
                //"C:\\Users\\nisha\\Downloads.file1.jpg"
        );

        Thread.sleep(2000);
        System.out.println("New Supplier added successfully!");
    }






    //EDIT A RECORD// ***************************************************************************************


    @Test
    public void testEditForm() throws InterruptedException {
        Thread.sleep(1000);

        supplierPage.clickOnEditButton();

        // Step 1: Locate the form fields and clear the existing values
        WebElement companyName = driver.findElement(By.xpath("//*[@id=\"company_name\"]"));
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement phone_number = driver.findElement(By.xpath("//*[@id=\"phone_number\"]"));

        companyName.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        phone_number.clear();

        Thread.sleep(2000);

        // Step 2: Enter new values
        companyName.sendKeys("John's Company");
        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys("johndoe@gmail.com");
        phone_number.sendKeys("076123456");

        Thread.sleep(1000);

        // Step 3: Submit the form
        WebElement saveButton = driver.findElement(By.id("submitf"));
        saveButton.click();

        Thread.sleep(2000);
        System.out.println("You have successfully updated the supplier");
    }





    //DELETE A RECORD// ****************************************************************************************

    @Test
    public void testDeleteForm() throws InterruptedException {
        Thread.sleep(1000);

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"sortable_table\"]/tbody/tr[1]/td[1]/label/span"));
        if (!checkbox.isSelected()) {
            checkbox.click();

            WebElement deleteButton = driver.findElement(By.id("delete"));
            deleteButton.click();

            Thread.sleep(2000);

            WebElement cancelButton = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button[1]"));
            WebElement okButton = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button[2]"));

            if (cancelButton.isSelected()){
                cancelButton.click();
                Thread.sleep(1000);
            }else{
                okButton.click();
                Thread.sleep(1000);
                System.out.println("You have successfully deleted the supplier");
            }
        }
    }






//SEARCH A RECORD// ****************************************************************************************


    @Test
    public void testSearchFunctionality() throws InterruptedException {

        // Step 1: Locate the search box and enter a query
        WebElement searchBox = driver.findElement(By.id("search"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_form\"]/div/ul/li[2]/button"));
        WebElement crossButton = driver.findElement(By.xpath("//*[@id=\"search_form\"]/div/ul/li[3]"));

        searchBox.sendKeys("Shelani");
        searchButton.click();
        Thread.sleep(1000);
        crossButton.click();
        System.out.println("You have successfully searched the supplier");

//        searchBox.clear();
//        searchBox.sendKeys("45");

        supplierPage.visitSupplierPage();
    }




//CLEAR SELECTION// ****************************************************************************************

    @Test
    public void clearSelection() throws InterruptedException {
        Thread.sleep(1000);

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"sortable_table\"]/tbody/tr[1]/td[1]/label/span"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            Thread.sleep(1000);

            WebElement clearSelectionButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div[2]/div/a[4]"));
            clearSelectionButton.click();

            Thread.sleep(2000);
            System.out.println("You have successfully cleared the selected one");

        }
    }


//MAILING LABELS// ****************************************************************************************




    @Test
    public void mailingLabels() throws InterruptedException {
        Thread.sleep(1000);

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"sortable_table\"]/tbody/tr[1]/td[1]/label/span"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            Thread.sleep(1000);

            WebElement mailingLabelButton = driver.findElement(By.id("labels"));
            mailingLabelButton.click();

            Thread.sleep(2000);
            System.out.println("You have successfully selected the Mailing Labels Button");
        }
    }



    //EMAIL// ****************************************************************************************

    @Test
    public void sendEmail() throws InterruptedException {
        Thread.sleep(1000);

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"sortable_table\"]/tbody/tr[1]/td[1]/label/span"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            Thread.sleep(1000);

            WebElement clickEmailButton = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            clickEmailButton.click();

            Thread.sleep(2000);
            System.out.println("You have successfully selected");

        }
    }
}
