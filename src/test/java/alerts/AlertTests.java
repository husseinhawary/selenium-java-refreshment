package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        var alert = homePage.clickJavascriptAlerts();
        alert.triggerAlert();
        alert.acceptAlert();
        Assert.assertEquals(alert.getResultText(), "You successfully clicked an alert", "Result text is incorrect");
    }
}
