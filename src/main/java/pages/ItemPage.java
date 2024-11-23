package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='name']")
    private WebElement itemName;

    @FindBy(xpath = "//input[@id='barcode_name']")
    private WebElement barcodeName;

    @FindBy(xpath = "//input[@id='item_number']")
    private WebElement itemNumber;

    @FindBy(xpath = "//input[@id='product_id']")
    private WebElement productId;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement description;

    @FindBy(xpath = "//textarea[@id='long_description']")
    private WebElement longDescription;

    @FindBy(xpath = "//textarea[@id='info_popup']")
    private WebElement infoPopup;

    @FindBy(xpath = "//input[@id='weight']")
    private WebElement weight;

    @FindBy(xpath = "//input[@id='length']")
    private WebElement length;

    @FindBy(xpath = "//input[@id='width']")
    private WebElement width;

    @FindBy(xpath = "//input[@id='height']")
    private WebElement height;

    @FindBy(xpath = "//input[@id='default_quantity']")
    private WebElement defaultQuantity;

    @FindBy(xpath = "//input[@id='loyalty_multiplier']")
    private WebElement loyaltyMultiplier;

   public void enterItemName(){
       inputText(itemName,addedItemName);
   }
    public void enterBarcodeName(){
        inputText(barcodeName,"Test Barcode Name");
    }
    public void enterItemNumber(){
        inputText(itemNumber,"ITEM-01");
    }
    public void enterProductId(){
        inputText(productId,"PRODUCT-01");
    }
    public void enterDescription(){
        //scroll(0,1000);
        inputText(description,"Test Description");
    }
    public void enterLongDescription(){
        inputText(longDescription,"Test Long Description ... Test Long Description ... Test Long Description ... Test Long Description ... ");
    }
    public void enterInfoPopup(){
        inputText(infoPopup,"Test Information Popup when adding to sale");
    }
    public void enterLoyaltyMultiplier(){
        //scroll(0,400);
        inputText(loyaltyMultiplier,"Test Loyalty Multiplier");
    }

    public void enterWeight(){
       inputNumeric(weight,50);
    }

    public void enterWidth(){
       inputNumeric(width,20);
    }

    public void enterLength(){
       inputNumeric(length,100);
    }

    public void enterHeight(){
       inputNumeric(height,120);
    }

    public void enterQuantity(){
       inputNumeric(defaultQuantity,10);
    }

    public void scroll(int x, int y){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x,y);
    }



    @FindBy(xpath = "//div/a[@title='New Item']")
    private WebElement addNewBtn;

    public void clickOnAddNew(){clickElement(addNewBtn);}

    public void validateTheAddNewBtn(){
        presenceOfElementLocated(addNewBtn);
    }


    @FindBy(xpath = "//input[@id='submitf' and @type='submit' and @class='submit_button floating-button btn btn-lg btn-primary']")
    private WebElement saveButton;

    public void clickSaveBtn(){
        clickElement(saveButton);
    }
    public void presenceOfSaveBtn(){
        presenceOfElementLocated(saveButton);
    }
    public void testMandatoryField() {
        clickElement(saveButton);
        Assert.assertTrue(isRequiredError(itemErrorMsg),"Item Name error message is not displayed.");
    }

    @FindBy(xpath = "//div[@class='col-sm-9 col-md-9 col-lg-10']//span[@for='name']")
    private WebElement itemErrorMsg;

    public String getItemNameErrorMessage() {
        return itemErrorMsg.getText();
    }


    @FindBy(xpath = "//div[@class='col-sm-9 col-md-9 col-lg-10']//span[@for='category_id']")
    private WebElement categoryErrorMsg;

    public String getCatNameErrorMessage(){return categoryErrorMsg.getText();}

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement requiredFieldPopUp;

    @FindBy(xpath = "//a[@title='Variations']")
    private WebElement variationSection;

    public void skipToVariation(){
        clickElement(variationSection);
        Assert.assertTrue(isRequiredError(popUpMsg),"Required Field Mandatory Pop Up is Not Displayed");

    }
    @FindBy(xpath = "//div[@class='bootbox-body']")
    private WebElement popUpMsg;
    public String getValidationPopUp() {
        return popUpMsg.getText();
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement popUpOk;

    public void clickOnOKBtn() {
        clickElement(popUpOk);
    }

    @FindBy(xpath = "//a[@class='current' and @href='https://demo.phppointofsale.com/index.php/items/view/-1?redirect=items&progression=1']")
    private WebElement newItemPg;

    public void clickOnNewItemPage(){clickElement(newItemPg);}

    @FindBy(xpath = "//div[@class='col-sm-9 col-md-9 col-lg-10']/div[@class='selectize-control form-control form-inps single']/div/input")
    private WebElement category;

    public void clickOnCategory(){
        clickElement(category);
    }

    @FindBy(xpath = "//div[@class='selectize-dropdown single form-control form-inps']/div[@class='selectize-dropdown-content']")
    private WebElement catDropdown;

    public void testCatDropDown(){
        presenceOfElementLocated(catDropdown);
    }

    @FindBy(xpath = "//div[@class='selectize-dropdown-content']/div[@data-value='43']")
    private WebElement category1;

    public void testCategory1Value(){
        presenceOfElementLocated(category1);
    }

    public void clickCatValue(){
        clickElement(category1);
    }

    @FindBy(xpath = "//label[@for='is_favorite']")
    WebElement isFavourite;

    public void checkIsFavourite(){
        click(isFavourite);
    }

    @FindBy(xpath = "//div[@class='nav navbar-nav top-elements navbar-breadcrumb hidden-xs']/a[@href='https://demo.phppointofsale.com/index.php/items']")
    private WebElement itemPage;

    public void clickOnItemPg(){
        clickElement(itemPage);
    }

    @FindBy(xpath = "//input[@id='search']")
    private WebElement itemSearch;

    public void enterNameOnSearch(){
       inputText(itemSearch,addedItemName);
    }

    @FindBy(xpath = "//button[@type='submit']/span[2]")
    private WebElement searchIcon;

    public void searchEnterItem(){
        clickElement(searchIcon);
    }

    public String addedItemName= "Test Item Name";
    public void verifyTheSearchItem() {
        WebElement searchResult = driver.findElement(By.xpath("//tbody/tr[1]/td/a[text()='"+ addedItemName +"']"));
        Assert.assertTrue(searchResult.isDisplayed(), "The added item was not found in the search results.");
        System.out.println("Search Result: "+searchResult);
        System.out.println("Actual Result: "+ addedItemName);
    }






}
