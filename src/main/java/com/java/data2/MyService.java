package com.java.data2;

/**
 * This class provides service for reading properties, data file and writing data to a database
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class MyService {

    public static final MyService INSTANCE = new MyService();

    private Properties configProps;
    private String inputFile;

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

    /**
     * Initializes inputFile with the specified string
     * @param input
     */
    private void configInputFile(String input) {
        inputFile = input;
    }

    /**
     * Creates database connection using settings in a configuration file
     * @return Database connection object
     */
    private Connection configDatabase() {
        Connection conn = null;
        try {
            Class.forName(configProps.getProperty("db.driver.class"));
            conn = DriverManager.getConnection(configProps.getProperty("db.connection.url"),
                    configProps.getProperty("db.username"), configProps.getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * Reads data from a file.
     * @return List with PersonModel instances
     */
    private List<PersonModel> readFileData() {
        FileReaderDAO f = new FileReaderDAO(inputFile);
        f.load();
        return f.getList();
    }

    /**
     * Modifies database according to the specified command
     * @param input
     * @param command
     */
    public void writeDatabaseData(String input, String command) {
        configInputFile(input);
        String c = command.toLowerCase().trim();
        Connection conn = configDatabase();
        DatabaseDAO dd = new DatabaseDAO();
        List<PersonModel> list = readFileData();

        if (c.equals("add"))
            for (int i = 0; i < list.size(); i++) {
                dd.add(conn, list.get(i));
            }
        else if (c.equals("update"))
            for (int i = 0; i < list.size(); i++) {
                dd.update(conn, list.get(i));
            }
        else if (c.equals("delete"))
            for (int i = 0; i < list.size(); i++) {
                dd.delete(conn, list.get(i));
            }
        else
            throw new IllegalArgumentException("Wrong command!");
    }
}

