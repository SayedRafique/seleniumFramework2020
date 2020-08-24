package com.google.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {
    private Properties properties;

    // Constructor
    public FileUtilities() {

    }



    public Properties updatePropertyFile(Properties prop, String filePath) throws IOException {
        this.properties = prop;
        if (properties == null){
            properties = new Properties();
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);

            properties.forEach(( key,  value) -> {
                value = (System.getenv((String) key) != null) ? System.getenv((String) key) :
                        (System.getProperty((String) key) != null) ? System.getProperty((String) key):
                                value;
                properties.replace(key,value);
            });
        }
        return properties;
    }

    public static void createDirectory(String path){
        new File(path).mkdir();
    }

}
