package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFactory;

import java.util.List;

public class ItemTest extends BaseTest {

    @Test
    public void testLocation() {
        PageFactory.homePage.validateLocation();
    }

    @Test(dependsOnMethods = "testLocation")
    public void setLocation() {
        PageFactory.homePage.clickOnDefaultLocation();
    }

    @Test(dependsOnMethods = "setLocation")
    public void refreshDashBoard(){
        PageFactory.homePage.clickOnDashboard();
    }

    @Test(dependsOnMethods = "refreshDashBoard")
    public void testItemWidget() {
        PageFactory.homePage.validateTheItemWidget();
    }
    @Test(dependsOnMethods = "testItemWidget")
    public void clickItemWidget() {
        PageFactory.homePage.clickOnItemWidget();
    }

    @Test(dependsOnMethods = "clickItemWidget")
    public void testAddNewBtnIsExist() {
        PageFactory.itemPage.validateTheAddNewBtn();
    }

    @Test(dependsOnMethods = "testAddNewBtnIsExist")
    public void clickOnAddNewBtn() {
        PageFactory.itemPage.clickOnAddNew();
    }


    @Test(dependsOnMethods = "clickOnAddNewBtn")
    public void skipItemInfoSection(){
        PageFactory.itemPage.skipToVariation();

        String actualMessage1 =PageFactory.itemPage.getValidationPopUp();
        Assert.assertEquals(actualMessage1,"You must fill out the required fields before making other changes.","Validation message text does not match.");
    }

    @Test (dependsOnMethods = "skipItemInfoSection")
    public void verifyTheOKButtonOfPopUp() {
        PageFactory.itemPage.clickOnOKBtn();
    }

    @Test(dependsOnMethods = "verifyTheOKButtonOfPopUp")
    public void refreshTheNewItemPage1() {
        PageFactory.itemPage.clickOnNewItemPage();
    }

    @Test(dependsOnMethods = "refreshTheNewItemPage1")
    public void verifyTheSaveButtonIsExist() { PageFactory.itemPage.presenceOfSaveBtn();}

    @Test(dependsOnMethods = "verifyTheSaveButtonIsExist")
    public void clickOnSaveWithoutMandatoryFields(){
        PageFactory.itemPage.testMandatoryField();

        String actualMessage2 = PageFactory.itemPage.getItemNameErrorMessage();
        String actualMessage3 = PageFactory.itemPage.getCatNameErrorMessage();
        Assert.assertEquals(actualMessage2,"Item Name is a required field","Validation message text does not match.");
        Assert.assertEquals(actualMessage3,"Category is a required field","Validation message text does not match.");
    }

    @Test(dependsOnMethods = "clickOnSaveWithoutMandatoryFields")
    public void refreshTheNewItemPage2() {
        PageFactory.itemPage.clickOnNewItemPage();
    }


    @Test(dependsOnMethods = "refreshTheNewItemPage2")
    public void inputTextInToTextFields(){
        PageFactory.itemPage.enterItemName();
        PageFactory.itemPage.enterBarcodeName();
        PageFactory.itemPage.enterItemNumber();
        PageFactory.itemPage.enterProductId();
        PageFactory.itemPage.enterDescription();
        PageFactory.itemPage.enterLongDescription();
        PageFactory.itemPage.enterInfoPopup();
        PageFactory.itemPage.enterLoyaltyMultiplier();
    }

    @Test(dependsOnMethods = "inputTextInToTextFields")
    public void inputNumbersInToFields(){
        PageFactory.itemPage.enterWeight();
        PageFactory.itemPage.enterWidth();
        PageFactory.itemPage.enterLength();
        PageFactory.itemPage.enterHeight();
        PageFactory.itemPage.enterQuantity();
    }

    @Test(dependsOnMethods = "inputNumbersInToFields")
    public void clickOnCategoryDropdown(){
        PageFactory.itemPage.clickOnCategory();
    }

//    @Test(dependsOnMethods = "clickOnCategoryDropdown")
//    public void checkTheDropDownValuesUnderCategory(){
//        PageFactory.itemPage.testCatDropDown();
//    }

    @Test(dependsOnMethods = "clickOnCategoryDropdown")
    public void checkTheDropDownValueIsExist(){
        PageFactory.itemPage.testCategory1Value();
    }

    @Test(dependsOnMethods = "checkTheDropDownValueIsExist")
    public void clickOnValueOnCategoryDropDown(){
        PageFactory.itemPage.clickCatValue();
    }

    @Test(dependsOnMethods = "clickOnValueOnCategoryDropDown")
    public void verifyUserCanCheckIsFavourite(){
        PageFactory.itemPage.checkIsFavourite();
    }


    @Test(dependsOnMethods = "verifyUserCanCheckIsFavourite")
    public void saveItemInfo(){
        PageFactory.itemPage.clickSaveBtn();
    }

    @Test (dependsOnMethods = "saveItemInfo")
    public void goToTheItemPage(){
        PageFactory.itemPage.clickOnItemPg();
    }

    @Test(dependsOnMethods = "goToTheItemPage")
    public void typeAddedItemOnSearchBar(){
        PageFactory.itemPage.enterNameOnSearch();
    }

    @Test(dependsOnMethods = "typeAddedItemOnSearchBar")
    public void searchAddedItem(){
        PageFactory.itemPage.searchEnterItem();
    }

    @Test(dependsOnMethods = "searchAddedItem")
    public void verifyTheItemIsSearchedSuccessfully(){
        PageFactory.itemPage.verifyTheSearchItem();
    }

}
