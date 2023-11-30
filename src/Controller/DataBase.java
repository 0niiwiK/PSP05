package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    String url = "jdbc:mysql://localhost:3307";
    String user = "root";
    String password = "mi-contrasena";
    public DataBase() {
    }
    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    public Statement createStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }
}
