package com.java.data2;


/**
 * Writes data from a text file to database.
 */


public class Task2App {

    public static void main(String[] args) {
        MyService ms = MyService.INSTANCE;
        ms.writeDatabaseData("C:\\Projects\\javaData\\src\\main\\resources\\data.txt", "delete");  // accepts add, update and delete commands
    }
}
