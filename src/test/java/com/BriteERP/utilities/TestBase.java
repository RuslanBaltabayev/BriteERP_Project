package com.BriteERP.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {

    protected WebDriver driver;
    protected Actions action;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver=Driver.getDriver();
        action= new Actions(driver);
        softAssert=new SoftAssert();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
        softAssert.assertAll();

    }
}
