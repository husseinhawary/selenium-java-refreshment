package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) {
        if(browser.equalsIgnoreCase( "chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions());
        }else if (browser.equalsIgnoreCase(  "firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        goHome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result){
        String dateTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resouces\\screenshots\\" + result.getName() + dateTime + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.setHeadless(true);
        //chromeOptions.addArguments("headless=new");
        return chromeOptions;
    }
}
