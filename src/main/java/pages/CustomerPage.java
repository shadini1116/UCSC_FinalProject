package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage extends BasePage {

    private String searchType;

    //--Visit customer page--
    @FindBy(xpath = "//div[@id='choose_location_modal']/div/div/div[2]/ul/li[1]/a") // Location modal option
    private WebElement location;

    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[3]/a/span[2]") // Customers tab
    private WebElement customerTab;

    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[3]/ul/li[1]/a") // Customers button in dropdown
    private WebElement customerBtn;

    @FindBy(xpath = "//div[@class = 'nav navbar-nav top-elements navbar-breadcrumb hidden-xs']/a[text()='Customers']")
    // Page validation
    private WebElement validatePage;


    //--Add new customer--
    @FindBy(xpath = "//a[@id='new-person-btn']/span")
    private WebElement newCustomer;

    @FindBy(xpath = "//form[@id='customer_form']/div/div[1]/h3")
    private WebElement customerInfo;

    //--Form Fields--
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='address_1']")
    private WebElement address01;

    @FindBy(xpath = "//input[@id='address_2']")
    private WebElement address02;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement province;

    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//textarea[@id='comments']")
    private WebElement comments;

    @FindBy(xpath = "//textarea[@id='internal_notes']")
    private WebElement internalNotes;

    @FindBy(xpath = "//input[@id='balance']")
    private WebElement storeAccountBalance;

    @FindBy(xpath = "//input[@id='credit_limit']")
    private WebElement creditLimit;

    @FindBy(xpath = "//input[@id='amount_to_spend_for_next_point']")
    private WebElement amountToSpendForNextPoint;

    @FindBy(xpath = "//input[@id='points']")
    private WebElement points;

    @FindBy(xpath = "//input[@id='company_name']")
    private WebElement companyName;

    @FindBy(xpath = "//input[@id='account_number']")
    private WebElement accountNumber;

    @FindBy(xpath = "//textarea[@id='customer_info_popup']")
    private WebElement messageToShow;


    //--Dropdowns--
    @FindBy(xpath = "//select[@id='section_names']")
    private WebElement terms;

    @FindBy(id = "tier_id")
    private WebElement tierType;

    //--Submit Button--
    @FindBy(xpath = "(//input[@name='submitf'])[1]")
    private WebElement saveButton;

    //--Validation Messages--
    @FindBy(xpath = "//span[@class='text-danger']")
    private WebElement validationError;

    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboardLabel;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchField;

    @FindBy(xpath = "//select[@id='search_type_id']")
    private WebElement selectCategoryBox;

    @FindBy(xpath = "//form[@id='search_form']/div/ul/li[4]/button/span[2]")
    private WebElement searchButton;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void ignoreLocation() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement locationModal = wait.until(ExpectedConditions.elementToBeClickable(location));
            System.out.println("Location modal detected. Clicking...");
            locationModal.click();
        } catch (TimeoutException e) {
            System.out.println("Location popup not detected. Skipping...");
        }
    }

    //--Reusable Method to Fill Fields--
    private void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    //--Reusable Method for Dropdown Selection--
    private void selectDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    //--Reusable Method for Checkboxes--
    private void setCheckbox(WebElement checkbox, boolean value) {
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }

    public void testLocation() {
        ignoreLocation();

    }


    // To visit customer page
    public void visitCustomerPage() {
        // Click the Customers tab
        try {
            //driver.navigate().to("https://demo.phppointofsale.com/index.php/customers");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = driver.findElement(By.xpath("//html/body/div[3]/div[1]/ul/li[3]/a/span[2]"));
            element.click();
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = driver.findElement(By.xpath("//html/body/div[3]/div[1]/ul/li[3]/a/span[2]"));
            element.click();
            //driver.navigate().to("https://demo.phppointofsale.com/index.php/customers");
        }


        // Click the Customers button in the dropdown
        click(customerBtn);

        // Validate that the Customers page is loaded
        presenceOfElementLocated(validatePage);
    }

    //--Fill customer Form--
    //--Method to Fill the Entire Customer Form--
    public void fillCustomerForm(String firstName, String lastName, String email, String phoneNumber, String address01, String address02,
                                 String city, String province, String zip, String country, String comments, String internalNotes,
                                 String storeAccountBalance, String creditLimit, String amountToSpendForNextPoint,
                                 String points, String companyName, String accountNumber, String messageToShow, String toShow) {

        // Fill all text fields
        fillField(this.firstName, firstName);
        fillField(this.lastName, lastName);
        fillField(this.email, email);
        fillField(this.phoneNumber, phoneNumber);
        fillField(this.address01, address01);
        fillField(this.address02, address02);
        fillField(this.city, city);
        fillField(this.province, province);
        fillField(this.zip, zip);
        fillField(this.country, country);
        fillField(this.comments, comments);
        fillField(this.internalNotes, internalNotes);
        fillField(this.storeAccountBalance, storeAccountBalance);
        fillField(this.creditLimit, creditLimit);
        fillField(this.amountToSpendForNextPoint, amountToSpendForNextPoint);
        fillField(this.points, points);
        fillField(this.companyName, companyName);
        fillField(this.accountNumber, accountNumber);
        fillField(this.messageToShow, messageToShow);

        // Handling the "Terms" dropdown

    }

    //--Submit the Form--
    public void submitForm() {
        saveButton.click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //--Method to Get Validation Errors--
    public String getValidationError() {
        return validationError.getText();
    }

    // Add new Customer
    public void addNewCustomer(String firstName, String lastName, String email, String phoneNumber, String address01, String address02,
                               String city, String province, String zip, String country, String comments, String internalNotes,
                               String storeAccountBalance, String creditLimit, String amountToSpendForNextPoint,
                               String points, String companyName, String accountNumber, String messageToShow) {
        // Click the "Add New Customer" button
        click(newCustomer);

        // Wait for the form to load
        presenceOfElementLocated(customerInfo);

        // Fill out the form
        fillCustomerForm(firstName, lastName, email, phoneNumber, companyName, address01, address02, city, province, zip, country,
                comments, internalNotes, storeAccountBalance, creditLimit, amountToSpendForNextPoint, points, companyName,
                accountNumber, messageToShow);

        // Submit the form
        submitForm();
        click(customerTab);
        click(customerBtn);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.navigate().refresh();
       // WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    //------------------Search---------------------------------------------------
    public void typeOnSearchField(String value) {
        this.fillField(this.searchField, value);
    }

    public void selectOptionOnCategoryBox(String visibleText) {
        searchType = visibleText;
        new Select(selectCategoryBox).selectByVisibleText(visibleText);
    }

    public <T> T clickOnSearchButton() {
        searchButton.click();
        if (searchType.equals("Name")) {
            return PageFactory.initElements(driver, (Class<? extends T>)
                    CustomerPage.class);
        }
        return null;

    }

    //------------------------------------------------Edit-------------------------------------------------------
    @FindBy(xpath = "//table[@id='sortable_table']/tbody/tr[1]/td[2]/div/a") // Replace with correct XPath
    private WebElement editBtn;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/nav/div[2]/a[3]") // Replace with correct XPath
    private WebElement updateCustomer;

    @FindBy(xpath = "//input[@id='first_name']") // Replace with correct XPath
    private WebElement firstNameFieldInEditForm;

    @FindBy(xpath = "//input[@id='last_name']") // Replace with correct XPath
    private WebElement lastNameFieldInEditForm;

    @FindBy(xpath = "//input[@id='email']") // Replace with correct XPath
    private WebElement emailFieldInEditForm;

    @FindBy(xpath = "//input[@id='phone_number']") // Replace with correct XPath
    private WebElement phoneNumberFieldInEditForm;

    @FindBy(xpath = "//input[@id='address_1']") // Replace with correct XPath
    private WebElement address01FieldInEditForm;

    @FindBy(xpath = "//input[@id='address_2']") // Replace with correct XPath
    private WebElement address02FieldInEditForm;


    @FindBy(xpath = "(//input[@name='submitf'])[1]")
    private WebElement saveUpdate;


    public void EditCustomerForm(String firstname, String lastName, String email, String phoneNumber) {
        fillField(this.firstNameFieldInEditForm,firstname);
        fillField(this.lastNameFieldInEditForm,lastName);
        fillField(this.emailFieldInEditForm, email);
        fillField(this.phoneNumberFieldInEditForm,phoneNumber);
       // fillField(this.address01FieldInEditForm,address01);
      //  fillField(this.address02FieldInEditForm,address02);

    }

    public void EditCustomer(String firstname, String lastName, String email, String phoneNumber) {

        click(editBtn);
        presenceOfElementLocated(updateCustomer);
        EditCustomerForm(firstname, lastName, email, phoneNumber);
        click(saveUpdate);

    }


    //-----------------------Delete customer------------------------------------------------------------------------

    @FindBy(xpath = "//table[@id='sortable_table']/tbody/tr[1]/td[1]") // Replace with correct XPath
    private WebElement firstRawOfCustomerList;

    @FindBy(xpath = "//a[@id='delete']/span[2]") // Confirm delete button in modal
    private WebElement DeleteBtn;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/button[2]") // Confirm delete button in modal
    private WebElement confirmDelete;

    public void DeleteCustomerRecord(){

        click(firstRawOfCustomerList);
        click(DeleteBtn);
        click(confirmDelete);
    }



}
