package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import util.Initialized;
import util.Manager;


public class LoginScript extends Initialized{
    private WebDriver driver;
    @Test
    public void testLogin(){
        driver = Manager.getDriver();
        Login loginPage = new Login();
        loginPage.loginUser();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://www.saucedemo.com/inventory.html");
    }
}