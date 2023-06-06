package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectedOption(){
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropdown("Option 1");
        var selectedOptions = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOptions.size(), 1, "incorrect number of selection");
        Assert.assertTrue(selectedOptions.contains("Option 1"), "Option not selected");
    }
}
