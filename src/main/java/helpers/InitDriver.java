package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitDriver {
    WebDriver webDriver;

    public WebDriver getDriver() {
        if (null != System.getProperty("driver")) {
            String driver = System.getProperty("driver");
            if (driver.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                return webDriver;
            } else if (driver.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                return webDriver;
            }
        }
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        return webDriver;
    }


    public WebDriver getDriverFromAppProperties() {
        try {
            Properties properties = new Properties();
            FileReader fileReader = new FileReader("src/main/resources/app.properties");
            properties.load(fileReader);
            String driver = properties.getProperty("driver");
            if (driver.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                return webDriver;
            } else if (driver.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                return webDriver;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}
