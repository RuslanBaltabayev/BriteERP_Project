package com.BriteERP.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BrowsereUtils {

    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 2000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static String getScreenshot(String name) {

        //String time = new SimpleDateFormat("yyyy/MM/dd h:mm:ssa").format(new Date());
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm:ssa"));
        //TakesScreenshot is an interface from selenium which takes screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir")+"/test-output/Screenshots/"+name+time+".png";
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source,finalDestination);
        } catch (IOException e) {

        }
        return target;
    }


}
