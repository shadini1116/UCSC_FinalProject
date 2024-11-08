package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertyFileReader;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage initApp() {
        String url = PropertyFileReader.getProperty("src/main/resources/config.properties", "applicationEndpoint");
        driver.get(url);
        return this;
    }
    public void clickLoginButton(){
        click(loginButton);
    }

}
