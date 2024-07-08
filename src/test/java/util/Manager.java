package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Manager {
    private static final Logger log = LoggerFactory.getLogger(Manager.class);
    private static WebDriver driver;
    public static Properties  properties;

    public static void loadProperties(){
        properties = new Properties();
        try {
            FileInputStream configStream = new FileInputStream("src/test/java/config/config.txt");
            properties.load(configStream);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){
        if (driver == null){
            loadProperties();
            String browserType = properties.getProperty("browser");
            String headlessMode = properties.getProperty("headless");
            if ("chrome".equalsIgnoreCase(browserType)){
                System.setProperty("webdriver.chrome.driver", "src/test/java/util/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                if (headlessMode.equalsIgnoreCase("true")){
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
            } else if ("firefox".equalsIgnoreCase(browserType)) {
                log.info("Need implement ");
            }
        }
        return driver;
    }

    public static void quickDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
