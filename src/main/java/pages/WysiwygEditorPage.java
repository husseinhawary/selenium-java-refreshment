package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WysiwygEditorPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndent = By.xpath("//div[@title='indentation']//button[@aria-label='Decrease indent']");
    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToEditArea();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textArea));
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
//        wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(textArea));
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void deceaseIndentation(){
        driver.findElement(decreaseIndent).click();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
