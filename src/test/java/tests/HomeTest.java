package tests;

import org.testng.annotations.*;
import pages.HomePage;
import pages.PageFactory;
import utils.Drivers;

public class HomeTest extends BaseTest {

    @Test
    public void testHomePageFeature() {
        PageFactory.homePage.validateTheTitle();
    }

}
