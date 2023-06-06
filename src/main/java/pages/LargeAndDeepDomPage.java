package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By table = By.id("large-table");
    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }
    public void scrollToTable(){
        WebElement webElement = driver.findElement(table);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
    }
}
