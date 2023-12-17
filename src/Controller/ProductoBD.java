/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Producto;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoBD {

    private static Statement stmt = null;
    private static ResultSet rs = null;

    public ProductoBD(int cliente) {
        try {
            // Tomas: debe ser PreparedStatement.
            stmt = DataBase.getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //rs = st.executeQuery("SELECT * FROM segundaTabla WHERE FK_de_Emplado = " + numero);
            rs = stmt.executeQuery("SELECT * FROM Producto WHERE cliCliente = " + cliente);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean esVacio() {
        try {
            if (rs.next()){
                rs.beforeFirst();
                return false;
            }
            else return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }    

    public Producto leer() {
        Producto producto = null;
        try {
            producto = new Producto(rs.getInt(1),rs.getString(2),rs.getFloat(3),dateToGCalendar(rs.getDate(4)),rs.getInt(5));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    public GregorianCalendar dateToGCalendar (java.util.Date d){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal;        
    }

    public boolean siguiente() {
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean anterior() {
        try {
            return rs.previous();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean primero() {        
        try {
            return rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        

    public boolean ultimo() {        
        try {
            return rs.last();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public boolean esUltimo() {
        try {
            return rs.isLast();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean esPrimero() {
        try {
            return rs.isFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void cerrar() {
        try {
            rs.close();            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void insertar(Producto producto) {
        try {
            rs.moveToInsertRow();
            rs.updateInt(1,producto.getId());
            rs.updateString(2,producto.getNombre());
            rs.updateFloat(3,producto.getPrecio());
            rs.updateDate(4, producto.getFecha_compra_date());
            rs.insertRow();
            rs.moveToCurrentRow();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Producto producto) {
        try {
            rs.updateInt(1,producto.getId());
            rs.updateString(2,producto.getNombre());
            rs.updateFloat(3,producto.getPrecio());
            rs.updateDate(4,producto.getFecha_compra_date());
            rs.updateRow();
            rs.moveToCurrentRow();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
