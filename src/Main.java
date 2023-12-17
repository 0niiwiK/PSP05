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
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        try {
            DataBase.iniciar();
            DataBase.cargarDatos();
            Cliente cliente = new ClienteLogin("Kiwi", "1234").getCliente();
            System.out.println("Codigo: " + cliente.getId());
            ProductoBD productoBD = new ProductoBD(cliente.getId());
            char op;
            if (!productoBD.esVacio()) {
                productoBD.siguiente();
                do {
                    System.out.println(productoBD.leer());
                    System.out.print("Opcion (s)iguiente, (a)nterior, (p)rimero, (u)ltimo, (0)cancelar: ");
                    op = src.nextLine().charAt(0);
                    switch (op) {
                        case 's':
                            if (productoBD.esUltimo())
                                System.out.println("No hay mas elementos");
                            else
                                productoBD.siguiente();
                            break;
                        case 'a':
                            if (productoBD.esPrimero())
                                System.out.println("No hay mas elementos");
                            else
                                productoBD.siguiente();
                            break;
                        case 'p':
                            if (productoBD.primero())
                                break;
                        case 'u':
                            if (productoBD.ultimo())
                                break;
                        case '0':
                            break;
                    }
                    System.out.println("");
                }
                while (op != '0');
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (MiExcepcion e) {
            System.out.println(MError.getMensaje(e.getCodigo()));
        }
    }
}