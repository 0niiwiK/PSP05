package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static Controller.DataBase.stmt;

public class ActualizarProducto {

    public static void introducirProducto( String nombre_producto, float precio_producto, int id_cliente) throws SQLException {
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
