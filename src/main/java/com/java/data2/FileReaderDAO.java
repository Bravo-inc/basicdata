package com.java.data2;

/**
 * Loads and parses data file, fills the list with PersonModel objects.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderDAO {

    private String path;
    private List<PersonModel> list = new ArrayList<PersonModel>();

    public FileReaderDAO(String path) {
        this.path = path;
    }
    public void load() {
        try {
            Scanner in = new Scanner(new File(path));
            while (in.hasNextLine()) {
                String line = in.nextLine();

                String[] values = line.split(", ");
                list.add(new PersonModel(values[0], values[1], values[2],
                        values[3], values[4], values[5], values[6]));
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<PersonModel> getList() {
        return list;
    }
}
