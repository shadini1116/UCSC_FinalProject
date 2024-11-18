package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PropertyFileReader;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://demo.phppointofsale.com/index.php/items/view/-1?redirect=items&progression=1' and @title='New Item']")
    private WebElement addNewBtn;
    public void validateAddNewButton(){
        presenceOfElementLocated(addNewBtn);
    }
    public void clickOnAddNew() {
        clickElement(addNewBtn);
    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement itemName;

    public void itemNameTextField(){
        presenceOfElementLocated(itemName);
    }
    public void inputItemName() {
        inputText(itemName,"Test Item Name");
    }

    @FindBy(xpath = "//input[@id='submitf' and @type='submit' and @class='submit_button floating-button btn btn-lg btn-primary']")
    private WebElement saveButton;
    public void presenceOfSaveBtn(){
        presenceOfElementLocated(saveButton);
    }
    public void clickOnSaveButton() {
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



}
