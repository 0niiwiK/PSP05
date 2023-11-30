package main.java;

import java.sql.*;
import Controller.DataBase;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBase db = new DataBase();
        try {
            Statement stmt = db.createStatement(db.connection());
            stmt.execute("SELECT * FROM 'users'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}