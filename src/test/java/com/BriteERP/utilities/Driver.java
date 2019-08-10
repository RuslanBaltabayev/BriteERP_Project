package com.BriteERP.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                    default:
                        System.out.println("We use only chrome and firefox as an testing browser");
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
