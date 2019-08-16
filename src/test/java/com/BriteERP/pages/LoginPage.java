package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@Test
    public void test(){
        extentLogger = report.createTest("Login Tests");
        extentLogger.info("We can write each step and explain what is going on in this step");
        extentLogger.info("Second step what ever we want to write");
        extentLogger.pass("Last not what we want to print in case of pass the test case");
}

}
