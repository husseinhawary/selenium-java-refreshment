package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By fileUploadInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileTitle = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }
    public void uploadFile(String absolutePathFile){
        driver.findElement(fileUploadInput).sendKeys(absolutePathFile);
        clickUploadButton();
    }
    public String getUploadedFileTitle(){
        return driver.findElement(uploadedFileTitle).getText();
    }
}
