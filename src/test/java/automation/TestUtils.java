package automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestUtils {

    public WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("about:blank");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    public void capturePageScreenshot(String fileName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
