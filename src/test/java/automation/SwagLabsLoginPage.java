package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;

public class SwagLabsLoginPage {

    WebDriver driver;
    By header = By.xpath("//div[text()='Swag Labs']");
    By usernameTextBox = By.id("user-name");
    By passwordTextBox = By.id("password");
    By loginButton = By.id("login-button");


    public SwagLabsLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyPageHeader(){
        boolean pageHeaderSwagLabs = driver.findElement(header).isDisplayed();
        Assert.assertTrue(pageHeaderSwagLabs);
    }

    public void enterUserNameAndPassword(String username, String password){
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


}
