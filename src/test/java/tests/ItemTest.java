package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageFactory;

public class ItemTest extends BaseTest {

    @Test
    public void testLocation() {
        PageFactory.homePage.validateLocation();
    }

    @Test(dependsOnMethods = "testLocation")
    public void setLocation() {
        PageFactory.homePage.clickOnDefaultLocation();
    }

    @Test(priority = 1)
    public void testItemWidget() {
        PageFactory.homePage.validateTheItemWidget();
    }
    @Test(dependsOnMethods = "testItemWidget")
    public void clickItemWidget() {
        PageFactory.homePage.clickOnItemWidget();
    }
    @Test(dependsOnMethods = "clickItemWidget")
    public void testAddNewBtn() {
        PageFactory.itemPage.validateAddNewButton();
    }

    @Test (dependsOnMethods = "testAddNewBtn")
    public void clickAddNew() {
        PageFactory.itemPage.clickOnAddNew();
    }

    //Test related to the Input Fields of Add New Item Form
//    @Test (dependsOnMethods = "clickAddNew")
//    public void verifyTheItemNameFieldIsExist() {
//        PageFactory.itemPage.itemNameTextField();
//    }
//
//    @Test(dependsOnMethods = "verifyTheItemNameFieldIsExist")
//    public void inputTextInToItemName(){
//        PageFactory.itemPage.inputItemName();
//    }

    @Test(dependsOnMethods = "clickAddNew")
    public void verifyTheSaveButtonIsExist(){
        PageFactory.itemPage.presenceOfSaveBtn();
    }

    @Test(dependsOnMethods = "verifyTheSaveButtonIsExist")
    public void clickOnSaveWithoutMandatoryFields(){
        PageFactory.itemPage.clickOnSaveButton();

        String actualMessage = PageFactory.itemPage.getItemNameErrorMessage();
        Assert.assertEquals(actualMessage,"Item Name is a required field","Validation message text does not match.");

    }


}
