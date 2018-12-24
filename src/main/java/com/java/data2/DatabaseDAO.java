package com.java.data2;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
    public void add(Connection c, PersonModel p) {
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO PERSON VALUES ('" + p.getLastName() +
                    "', '" + p.getFirstName() + "', '" + p.getBirthYear() +
                    "', '" + p.getCity() + "', '" + p.getStreet() + "', '" +
                    p.getHouse() + "', '" + p.getApartment() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection c, PersonModel p) {
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE PERSON SET lastName='" + p.getLastName() +
                    "', firstName='" + p.getFirstName() + "', birthYear='" + p.getBirthYear() +
                    "', city='" + p.getCity() + "', street='" + p.getStreet() +
                    "', house='" + p.getHouse() + "', apartment='" + p.getApartment() +
                    "' WHERE lastName='" + p.getLastName() + "' AND birthYear='" + p.getBirthYear() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Connection c, PersonModel p) {
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM PERSON WHERE lastName='" + p.getLastName() +
                    "' AND firstName='" + p.getFirstName() + "' AND birthYear='" + p.getBirthYear() +
                    "' AND city='" + p.getCity() + "' AND street='" + p.getStreet() +
                    "' AND house='" + p.getHouse() + "' AND apartment='" + p.getApartment() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}