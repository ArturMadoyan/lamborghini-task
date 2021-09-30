package tests;

import helpers.InitDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void initDriver() {
        InitDriver initDriver = new InitDriver();
        driver = initDriver.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
