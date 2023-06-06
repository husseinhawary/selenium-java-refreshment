package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    public By loadingIndicator = By.id("loading");
    public By loadedText = By.id("finish");
    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStart(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
