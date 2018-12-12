package com.javadata1;

import java.io.*;
import java.util.Properties;

public class MyService {
    public static final MyService INSTANCE = new MyService();
    private Properties configProps;

    private MyService() {
        configProps = new Properties();
        try {
            configProps.load(MyService.class.getClassLoader().getResourceAsStream("config.properties"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProps() {
        return configProps;
    }
}