package automation;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class SwagLabsTest extends TestUtils {

    SwagLabsLoginPage swagLabsLoginPage;

    @Test()
    public void loginToSwagLabs(){
        swagLabsLoginPage = new SwagLabsLoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        swagLabsLoginPage.enterUserNameAndPassword("standard_user","secret_sauce");
        swagLabsLoginPage.clickLoginButton();
        swagLabsLoginPage.verifyPageHeader();
        capturePageScreenshot("LoginSuccessful");
    }

    @Test()
    public void addItemToCart(){
        System.out.println("addItemsToCart");
    }









}
