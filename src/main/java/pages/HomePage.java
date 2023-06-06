package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private String formAuthenticationLink = "Form Authentication";
    private String dropdownLink = "Dropdown";
    private String hoversLink = "Hovers";
    private String keyPressesLink = "Key Presses";
    private String alertsLink = "JavaScript Alerts";
    private String fileUploadLink = "File Upload";
    private String wysiwygEditorLink = "WYSIWYG Editor";
    private String dynamicLoadingLink = "Dynamic Loading";
    private String largeAndDeepDomLink = "Large & Deep DOM";
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public LoginPage clickFormAuthentication(){
        clickLink(formAuthenticationLink);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown(){
        clickLink(dropdownLink);
        return new DropdownPage(driver);
    }
    public HoversPage clickHovers(){
        clickLink(hoversLink);
        return new HoversPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        clickLink(keyPressesLink);
        return new KeyPressesPage(driver);
    }
    public AlertsPage clickJavascriptAlerts(){
        clickLink(alertsLink);
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink(fileUploadLink);
        return new FileUploadPage(driver);
    }
    public WysiwygEditorPage clickWysiwygEditorLink(){
        clickLink(wysiwygEditorLink);
        return new WysiwygEditorPage(driver);
    }
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink(dynamicLoadingLink);
        return new DynamicLoadingPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink(largeAndDeepDomLink);
        return new LargeAndDeepDomPage(driver);
    }

}
