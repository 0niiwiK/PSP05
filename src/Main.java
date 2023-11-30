import Controller.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        try {
            DataBase db = new DataBase();
            db.inicializar();
            Statement stmt = db.obtenerStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Producto" +
                    " INNER JOIN Cliente ON Producto.cliCliente = Cliente.id");
            while (rs.next()) {
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i + 1)+" ");
                }
                System.out.println("si");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}