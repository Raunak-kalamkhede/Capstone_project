package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ApiManager;
import utils.ExcelManager;
import utils.JMeterManager;
import utils.WebDriverManager;

public class OmniSteps 
{
    String[] credentials;

    @Given("the backend API is validated and active via Rest-Assured")
    public void validateAPI() 
    {
        ApiManager.validateBackendStatus();
    }

    @Given("I read user credentials dynamically from the Excel sheet")
    public void readExcelData() throws Exception 
    {
        credentials = ExcelManager.getCredentials();
        System.out.println("Fetched User: " + credentials[0] + " from Excel");
    }

    @When("I execute a UI login on SauceDemo via Selenium Grid")
    public void executeUILogin() throws Exception 
    {
        WebDriver driver = WebDriverManager.getDriver();
        
        System.out.println("Navigating to SauceDemo UI...");
        driver.get("https://www.saucedemo.com/");
        
        // SauceDemo specific locators
        driver.findElement(By.id("user-name")).sendKeys(credentials[0]);
        driver.findElement(By.id("password")).sendKeys(credentials[1]);
        driver.findElement(By.id("login-button")).click();
        
        // Basic sync wait
        Thread.sleep(2000); 
        
        // After login, SauceDemo redirects to the inventory page
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "UI Login Failed!");
        System.out.println("UI Login Successful! Triggering JMeter...");
    }

    @Then("I stress test the backend infrastructure using JMeter")
    public void executePerformanceTest() throws Exception 
    {
        JMeterManager.executeLoadTest();
    }
}