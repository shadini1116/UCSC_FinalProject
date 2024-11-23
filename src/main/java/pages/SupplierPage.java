package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SupplierPage extends BasePage {
    @FindBy(xpath = "//span[text()='Suppliers']")
    private WebElement suppliersTab;

    @FindBy(xpath = "//span[text()=' New Supplier']")
    private WebElement newSupplier;

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement companyName;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='phone_number']")
    private WebElement phone_number;

    @FindBy(xpath = "(//input[@id='submitf'])[1]")
    private WebElement saveBtn;

    @FindBy(xpath = "//form[@id='supplier_form']/div/div[1]/h3")
    private WebElement supplierInfo;

    @FindBy(xpath = "//span[text()=' Choose file']")
    private WebElement ChooseFile;

    @FindBy(xpath = "//input[@id='image_id']")
    private WebElement image_id;

    // Path to the image to upload
    String filePath = "C:\\Users\\nisha\\Downloads.avatar.png";

    // Method to upload the file
    public void uploadFile(String s) {
        // Upload the file using the file input element
        image_id.sendKeys(filePath);
    }

    @FindBy(xpath = "//input[@id='address_1']")
    private WebElement address_1;

    @FindBy(xpath = "//input[@id='address_2']")
    private WebElement address_2;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//textarea[@id='comments']")
    private WebElement comments;

    @FindBy(xpath = "//textarea[@id='internal_notes']")
    private WebElement internal_notes;

    @FindBy(xpath = "//input[@id='account_number']")
    private WebElement account_number;

    @FindBy(xpath = "//select[@id='section_names']")
    private WebElement section_names;

    String selectedTerm = "None";

    public void selectTerm(String term) {
        section_names.clear();  // Clear any previous input
        section_names.sendKeys(term);  // Type the desired term
        selectedTerm = term;  // Store the selected term
    }


    @FindBy(xpath = "//input[@id='files_1']")
    private WebElement files_1;

    String filePath1 = "C:\\Users\\nisha\\IdeaProjects\\Selenium\\USCS_QA_POS\\UCSC_FinalProject\\src\\main\\resources";


    // Method to upload the file
    public void uploadFile1(String s) {
        // Upload the file using the file input element
        files_1.sendKeys(filePath1);
    }

    public void clickOnEditButton(){
        editButton.click();
    }

    @FindBy(xpath = "//*[@id=\"sortable_table\"]/tbody/tr[1]/td[2]/div/a")
    private WebElement editButton;


    @FindBy(xpath = "//*[@id=\"delete\"]")
    private WebElement deleteButton;

    public void clickOnDeleteButton(){
        deleteButton.click();
    }


    @FindBy(xpath = "//span[text()=' Mailing Labels']")
    private WebElement mailingLabels;

    public void clickOnMailingLabelsButton(){
        mailingLabels.click();

    }


    @FindBy(xpath = "//span[text()=' Clear Selection']")
    private WebElement clearSelectionButton;

    public void clickOnClearSelectionButton(){
        clearSelectionButton.click();

    }

    private void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public SupplierPage(WebDriver driver) {
        super(driver);
    }

    public void visitSupplierPage() {
        suppliersTab.click();
    }


    @FindBy(xpath = "//*[@id=\"choose_location_modal\"]/div/div/div[2]") // Location modal option
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"choose_location_modal\"]/div/div/div[2]/ul/li[1]/a") // Location modal option
    private WebElement locationDefault;

    public void ignoreLocation() {
        click(location);
    }

    //--Fill supplier Form--
    //--Method to Fill the Entire supplier Form--
    public void fillSupplierForm(String companyName, String firstName, String lastName, String email, String phone_number, String filePath, String address_1, String address_2, String city, String state, String zip, String country, String comments, String internal_notes, String account_number  ) {
        fillField(this.companyName, companyName);
        fillField(this.firstName, firstName);
        fillField(this.lastName, lastName);
        fillField(this.email, email);
        fillField(this.phone_number, phone_number);
        image_id.sendKeys(filePath);
        fillField(this.address_1, address_1);
        fillField(this.address_2, address_2);
        fillField(this.city, city);
        fillField(this.state, state);
        fillField(this.zip, zip);
        fillField(this.country, country);
        fillField(this.comments, comments);
        fillField(this.internal_notes, internal_notes);
        //fillField(this.account_number, account_number);
        //files_1.sendKeys(filePath1);
        //section_names.sendKeys(term);  // Type the desired term
        //selectedTerm = term;  // Store the selected term

    }

    //--Submit the Form--
    public void submitForm() {
        saveBtn.click();
    }


    public void addNewSupplier(String companyName, String firstName, String lastName, String email, String phone_number, String filePath, String address_1, String address_2, String city, String state, String zip, String country, String comments, String internal_notes, String account_number) throws InterruptedException {

        // Click the "Add New Supplier" button
        click(newSupplier);

        // Wait for the form to load
        presenceOfElementLocated(supplierInfo);

        // Fill out the form
        fillSupplierForm(companyName, firstName,lastName, email, phone_number, filePath, address_1, address_2,city,  state,  zip,  country,  comments,  internal_notes,  account_number );


        Thread.sleep(2000);
        //image_id.sendKeys(filePath);


        // Submit the form
        submitForm();
    }
}
