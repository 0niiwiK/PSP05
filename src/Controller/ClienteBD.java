/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Empleado;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class ClienteBD {
    Statement stmt; 
    ResultSet rs;
    
    public ClienteBD(String sWhere) {
        try {
            stmt = DataBase.createStatement();
            String consultaSQL="SELECT * FROM empleado "+ sWhere;
            System.out.println(consultaSQL);
            rs = stmt.executeQuery(consultaSQL);            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

        
    public ArrayList<Empleado> getEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            while (rs.next()) {
                empleados.add(new Empleado (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                                            rs.getFloat(5),rs.getFloat(6),dateToGCalendar(rs.getDate(7))));
            }
            return empleados;
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
    
    
    public void cerrar(){
        try {
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}