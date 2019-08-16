package com.BriteERP.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

  private static WebDriver driver;

  private Driver(){}

   public static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "chromeHeadless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "firefoxHeadless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Illegal browser type!");
            }

    }
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("imlicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Long.valueOf(ConfigurationReader.getProperty("implicitwait")),TimeUnit.SECONDS);
        return driver;

    }

    public static void closeDriver(){
       if(driver!=null){
           driver.quit();
           driver=null;
       }
    }


}
