package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Manager;

public class Login {
    private WebDriver driver;

    public Login(){
        this.driver = Manager.getDriver();
    }

    public void loginUser(){
        JSONObject jsonObject = CommonMethod.readJsonData("user.json");
        String username = (String) jsonObject.get("username");
        String pwd = (String) jsonObject.get("password");

        WebElement userInput = driver.findElement(By.id("user-name"));
        WebElement pwdInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userInput.sendKeys(username);
        pwdInput.sendKeys(pwd);
        loginBtn.click();
    }
}
