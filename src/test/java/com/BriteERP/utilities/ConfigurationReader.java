package com.BriteERP.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties pro;

    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            pro=new Properties();
            pro.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path: "+path+"-not exist!");
        }
    }

    public static String getProperty(String key){
        return pro.getProperty(key);
    }

}
