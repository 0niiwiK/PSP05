import Controller.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        try {
            DataBase db = new DataBase();
            db.cargarDatos();
            Statement stmt = db.obtenerStatement();
            introducirProducto(stmt, "Manzana", 1.20f, 1);
            introducirProducto(stmt, "Pera", 2.50f, 1);
            ResultSet rs = stmt.executeQuery("SELECT gastoTotal FROM Cliente WHERE id = 1;");
            rs.next();
            System.out.println("Importe total: " + rs.getString("gastoTotal"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void introducirProducto(Statement stmt, String nombre_producto, float precio_producto, int id_cliente) throws SQLException {
        String sentencia = "SELECT gastoTotal FROM Cliente WHERE id = "+id_cliente+";";
        ResultSet rs = stmt.executeQuery(sentencia);
        rs.next();
        float gasto;
        if (Objects.equals(rs.getString(1), "null")) {
            gasto = 0;
        } else {
            gasto = rs.getFloat(1);
        }
        stmt.execute("INSERT INTO Producto (nombre, precio, fecha_compra, cliCliente) VALUES ('"+nombre_producto+"', "+precio_producto+", '2020-01-01', "+id_cliente+");");
        gasto += precio_producto;
        stmt.execute("UPDATE Cliente SET gastoTotal = "+gasto+" WHERE id = 1;");
    }
}