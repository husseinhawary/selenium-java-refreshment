package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {
    private WebDriver driver;

    private By loginSuccessMsg = By.id("flash");

    public SecureArea(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginSuccessMsg(){
        return driver.findElement(loginSuccessMsg).getText();
    }
}
