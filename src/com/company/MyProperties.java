package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {

    private final Properties properties = new Properties();

    private MyProperties() {

        InputStream inputStream;

        try {

            inputStream = new FileInputStream("myProperties.properties");

            properties.load(inputStream);

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    public boolean containsKey(final String key) {
        return properties.containsKey(key);
    }


    public static MyProperties getInstance() {
        return Helper.INSTANCE;
    }

    private static class Helper {
        private static final MyProperties INSTANCE = new MyProperties();
    }

}
