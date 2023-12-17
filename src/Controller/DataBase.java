package Controller;

import java.sql.*;

public class DataBase {
    static String url = "jdbc:mysql://localhost:3307";
    static String user = "root";
    static String password = "mi-contrasena";
    static Statement stmt;
    static Connection conn;
    public DataBase() throws SQLException {
        createConnection();
        createStatement();
    }
    
    public static void createConnection() throws SQLException {
        conn = null;
        conn = DriverManager.getConnection(url, user, password);
    }

    public static void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public static Statement obtenerStatement() throws SQLException {
        return stmt;
    }

    public static void inicializar() throws SQLException {
        stmt.executeUpdate("DROP SCHEMA IF EXISTS Tienda");
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS Tienda");
        stmt.executeUpdate("USE Tienda");
        stmt.execute("DROP TABLE IF EXISTS Cliente;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Cliente (id INT NOT NULL AUTO_INCREMENT, user VARCHAR(20), password VARCHAR(15), gastoTotal FLOAT(10,2), PRIMARY KEY (id));");
        stmt.execute("DROP TABLE IF EXISTS Producto;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Producto (id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(20), precio FLOAT(10,2), fecha_compra DATE, cliCliente INT, PRIMARY KEY (id), FOREIGN KEY (cliCliente) REFERENCES Cliente(id));");
        stmt.execute("INSERT INTO Cliente (user, password) VALUES ('Usuario', 'Contrasenia');");
    }

    public static void cerrar() {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
