package hooks;

import io.cucumber.java.After;
import utils.WebDriverManager;

public class CapstoneHooks 
{
    @After
    public void tearDown() 
    {
        WebDriverManager.quitDriver();
    }
}