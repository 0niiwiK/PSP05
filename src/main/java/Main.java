package main.java;

import java.sql.*;
import Controller.DataBase;

public class Main {
    public static void main(String[] args){
        try {
            DataBase db = new DataBase();
            db.inicializar();
            Statement stmt = db.obtenerStatement();
            stmt.execute("INSERT INTO Ejemplo VALUES (1, 'Ejemplo')");
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM Ejemplo");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}