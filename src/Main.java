import Controller.ClienteLogin;
import Controller.DataBase;
import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try {
            DataBase.iniciar();
            DataBase.cargarDatos();
            Cliente cliente = new ClienteLogin("admin", "admin").getCliente();
            System.out.println("Codigo: " + cliente.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (MiExcepcion e) {
            System.out.println(MError.getMensaje(e.getCodigo()));
        }
    }
}