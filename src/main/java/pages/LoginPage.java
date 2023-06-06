package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.cssSelector("#login button");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String userName){
        driver.findElement(usernameField).sendKeys(userName);
    }
    public void setUserPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
        //return new SecureArea(driver);
    }
    public SecureArea userLogin(String userName, String userPassword){
        setUsername(userName);
        setUserPassword(userPassword);
        clickLoginBtn();
        return new SecureArea(driver);
    }
}
