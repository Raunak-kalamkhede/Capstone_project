package utils;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager 
{
    private static WebDriver driver;

    public static WebDriver getDriver() throws Exception 
    {
        if (driver == null) 
        {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            driver.manage().window().maximize();
            
            // THE FIX: Tell Selenium to wait up to 15 seconds for heavy web pages to load
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void quitDriver() 
    {
        if (driver != null) 
        {
            driver.quit();
            driver = null;
        }
    }
}