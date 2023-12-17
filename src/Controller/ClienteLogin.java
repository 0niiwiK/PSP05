package Controller;

import Model.Cliente;
import Model.MiExcepcion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteLogin {
    Statement stmt;
    Cliente cliente = null;

    public ClienteLogin(String user, String password) throws MiExcepcion {
        try {
            // Tomas: debe ser PreparedStatement.
            this.stmt = DataBase.getConn().createStatement();
            //rs = st.executeQuery("SELECT * FROM segundaTabla WHERE FK_de_Emplado = " + numero);
            ResultSet rs = stmt.executeQuery("SELECT id FROM Cliente WHERE BINARY user = '" + user + "' AND password = '" + password + "';");
            rs.next();
            this.cliente = new Cliente(rs.getInt(1));
            getDatos();
        } catch (SQLException ex) {
            throw new MiExcepcion(104);
        }
    }

    public void getDatos() throws MiExcepcion {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id, user, gastoTotal, password, imagen FROM Cliente WHERE id = " + cliente.getId() + ";");
            rs.next();
            this.cliente.setUser(rs.getString(2));
            this.cliente.setGastoTotal(rs.getFloat(3));
            this.cliente.setPassword(rs.getString(4));
            this.cliente.setImagen(rs.getString(5));
        } catch (SQLException ex) {
            throw new MiExcepcion(105);
        }
    }

    public Cliente getCliente() throws MiExcepcion {
        if (this.cliente == null) {
            throw new MiExcepcion(104);
        } else
            return this.cliente;
    }
}
