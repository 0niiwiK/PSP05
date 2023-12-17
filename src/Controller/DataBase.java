package Controller;

import Model.MiExcepcion;

import java.sql.*;

public class DataBase {
    static String url = "jdbc:mysql://localhost:3307";
    static String user = "root";
    static String password = "mi-contrasena";
    static Connection conn = null;
    
    public static void iniciar() throws MiExcepcion {
        conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Conexión ERROR");
            throw new MiExcepcion(102);
        }
    }

    public static Connection getConn() throws SQLException {
        return conn;
    }


    public static void cargarDatos() throws SQLException {
        Statement stmt = getConn().createStatement();
        stmt.executeUpdate("DROP SCHEMA IF EXISTS Tienda");
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS Tienda");
        stmt.executeUpdate("USE Tienda");
        stmt.execute("DROP TABLE IF EXISTS Cliente;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Cliente (id INT NOT NULL AUTO_INCREMENT, user VARCHAR(20), password VARCHAR(15), gastoTotal FLOAT(10,2), PRIMARY KEY (id));");
        stmt.execute("DROP TABLE IF EXISTS Producto;");
        stmt.execute("CREATE TABLE IF NOT EXISTS Producto (id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(20), precio FLOAT(10,2), fecha_compra DATE, cliCliente INT, PRIMARY KEY (id), FOREIGN KEY (cliCliente) REFERENCES Cliente(id));");
        stmt.execute("INSERT INTO Cliente (user, password) VALUES ('Usuario', 'Contrasenia');");
    }

    public static boolean cerrar() throws MiExcepcion {
        try {
            conn.close();
            //System.out.println("Conexión CERRADA");
            return true;
        }
        catch (SQLException e) {
            //Tomas: debug
            System.out.println(e.getMessage());
            System.out.println("Conexión ERROR AL CERRAR");
            //Tomas: aquí se guarda en el fichero de log: e.getMessge(), fecha y hora.
            throw new MiExcepcion(103);
        }
    }

}
