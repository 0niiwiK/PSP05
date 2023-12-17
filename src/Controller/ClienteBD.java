/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.MiExcepcion;
import Model.Producto;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteBD {
    Statement stmt;
    ResultSet rs;


    public ClienteBD(int cliente) {
        try {
            stmt = DataBase.getConn().createStatement();
            String consultaSQL="SELECT * FROM Producto WHERE cliCliente = "+ cliente +";";
            rs = stmt.executeQuery(consultaSQL);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            while (rs.next()) {
                productos.add(new Producto(rs.getInt(1),rs.getString(2),rs.getFloat(3),dateToGCalendar(rs.getDate(4)),rs.getInt(5)));
            }
            return productos;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    //Tomas: este método estaría mejor en una clase de utilidades (controlador)
    public GregorianCalendar dateToGCalendar (java.util.Date d){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal;
    }

    public void getDatos(Cliente cliente) throws MiExcepcion {
        try {
            Statement stmt = DataBase.getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, user, gastoTotal, password FROM Cliente WHERE id = " + cliente.getId() + ";");
            rs.next();
            cliente.setUser(rs.getString(2));
            cliente.setGastoTotal(rs.getFloat(3));
            cliente.setPassword(rs.getString(4));
        } catch (SQLException ex) {
            throw new MiExcepcion(105);
        }
    }


    public void cerrar(){
        try {
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}