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
        } catch (MiExcepcion e) {
            System.out.println(MError.getMensaje(e.getCodigo()));
        }
    }
}