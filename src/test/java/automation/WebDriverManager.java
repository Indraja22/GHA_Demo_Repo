package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private volatile static WebDriverManager webDriverManager;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverManager(){}
    private void initDriver(String browser){
        switch (browser){
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser : "+browser);
        }
    }
    public static WebDriverManager getInstance(String browser){

        if(webDriverManager == null){
            synchronized (WebDriverManager.class){
                if(webDriverManager == null){
                    webDriverManager = new WebDriverManager();
                }
            }
        }
        if (tlDriver.get() == null){
            webDriverManager.initDriver(browser);
        }
        return webDriverManager;
    }

    public WebDriver getDriver(){
        return tlDriver.get();
    }

    public static void quitBrowser(){
        if(tlDriver.get() != null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
