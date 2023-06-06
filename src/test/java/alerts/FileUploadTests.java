package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\hussien.abdelmoamen\\Desktop\\Ticket.png");
        Assert.assertEquals(uploadPage.getUploadedFileTitle(),"Ticket.png", "Invalid uploaded file title");
    }
}
