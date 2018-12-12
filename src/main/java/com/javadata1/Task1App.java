package com.javadata1;

import java.util.Properties;

public class Task1App {
    public static void main(String[] args) {
        Properties props = MyService.INSTANCE.getProps();

        String jdbcDriver = props.getProperty("db.driver.class");
        String url = props.getProperty("db.connection.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        System.out.println("JDBC Driver: " + jdbcDriver);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}