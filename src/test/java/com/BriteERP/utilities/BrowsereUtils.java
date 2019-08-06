package com.BriteERP.utilities;

public class BrowsereUtils {

    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 2000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
