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

    public void inicializar() throws SQLException {
        stmt.executeUpdate("DROP SCHEMA IF EXISTS Tienda");
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS Tienda");
        stmt.executeUpdate("USE Tienda");
        stmt.execute("DROP TABLE IF EXISTS Cliente;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Cliente (id INT NOT NULL AUTO_INCREMENT, user VARCHAR(20), password VARCHAR(15), gastoTotal FLOAT(10,2), PRIMARY KEY (id));");
        stmt.execute("DROP TABLE IF EXISTS Producto;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Producto (id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(20), precio FLOAT(10,2), fecha_compra DATE, cliCliente INT, PRIMARY KEY (id), FOREIGN KEY (cliCliente) REFERENCES Cliente(id));");
        stmt.execute("INSERT INTO Cliente (user, password) VALUES ('Usuario', 'Contrasenia');");
    }

    public void cerrar() {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
