package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureArea;
import utils.JsonDataReader;

import java.io.IOException;

public class LoginTests extends BaseTests {
    public JsonDataReader jsonDataReader;
    @Test
    public void testSuccessfulLogin() throws IOException, ParseException {
        jsonDataReader = new JsonDataReader();
        jsonDataReader.JsonReader();
        LoginPage loginPage =  homePage.clickFormAuthentication();
//        loginPage.setUsername(jsonDataReader.userName);
//        loginPage.setUserPassword(jsonDataReader.userPassword);
        SecureArea secureArea = loginPage.userLogin(jsonDataReader.userName, jsonDataReader.userPassword);
        Assert.assertTrue(secureArea.getLoginSuccessMsg().contains("You logged into a secure area!"),  "Alert text is incorrect");
    }
}
