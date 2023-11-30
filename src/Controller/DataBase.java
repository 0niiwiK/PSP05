package Controller;

import java.sql.*;

public class DataBase {
    String url = "jdbc:mysql://localhost:3307";
    String user = "root";
    String password = "mi-contrasena";
    Statement stmt;
    Connection conn;
    ResultSet rs;
    public DataBase() throws SQLException {
        createConnection();
        createStatement();
    }
    public void createConnection() throws SQLException {
        conn = null;
        conn = DriverManager.getConnection(url, user, password);
    }

    public void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public Statement obtenerStatement() throws SQLException {
        return stmt;
    }

    public ResultSet obtenerResultSet() throws SQLException {
        return rs;
    }

    public void inicializar() throws SQLException {
        stmt.executeUpdate("DROP SCHEMA IF EXISTS Tienda");
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS Tienda");
        stmt.executeUpdate("USE Tienda");
        stmt.executeUpdate("DROP TABLE IF EXISTS Ejemplo");
        stmt.executeUpdate("CREATE TABLE Ejemplo (id INT, nombre VARCHAR(255))");
    }

    public void cerrar() {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
