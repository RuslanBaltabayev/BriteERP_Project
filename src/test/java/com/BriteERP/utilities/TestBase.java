package com.BriteERP.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected Actions action;
    protected SoftAssert softAssert;
    protected Pages pages;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest(alwaysRun = true)
    public void setUpTest(){
        report = new ExtentReports();
        String filePath = System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment","Staging");
        report.setSystemInfo("Browser",ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("QA Engineer","Ruslan Baltabayev");
        htmlReporter.config().setDocumentTitle("BriteERP Reports");
        htmlReporter.config().setReportName("BriteERP Automated Test Reports");
       // htmlReporter.config().setTheme(Theme.DARK);

    }
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver=Driver.getDriver();
        action= new Actions(driver);
        softAssert=new SoftAssert();
        pages=new Pages();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {

        if(result.getStatus()== ITestResult.FAILURE){
            String screenshotLocation = BrowsereUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }else if(result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test Case skipped: "+result.getName());
        }
        Driver.closeDriver();
        softAssert.assertAll();

    }

}
