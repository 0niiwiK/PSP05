import Controller.ClienteBD;
import Controller.ClienteLogin;
import Controller.DataBase;
import Controller.ProductoBD;
import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;
import Model.Producto;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        try {
            DataBase.iniciar();
            DataBase.cargarDatos();
            Cliente cliente = new ClienteLogin("Kiwi", "1234").getCliente();
            System.out.println("Codigo: " + cliente.getId());
            ProductoBD productoBD = new ProductoBD(cliente.getId());
            char op;
            do {
                if (productoBD.esVacio())
            }
            while (true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (MiExcepcion e) {
            System.out.println(MError.getMensaje(e.getCodigo()));
        }
    }
}