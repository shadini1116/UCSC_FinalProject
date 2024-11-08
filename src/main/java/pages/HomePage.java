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



}


