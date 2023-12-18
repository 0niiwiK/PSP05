/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Date;
import java.util.GregorianCalendar;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private GregorianCalendar fecha_compra;
    private int id_cliente;

    public Producto(int id, String nombre, float precio, GregorianCalendar fecha_compra, int id_cliente) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha_compra = fecha_compra;
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public GregorianCalendar getFecha_compra_gc() {
        return fecha_compra;
    }

    public java.util.Date getFecha_compra_date() {
        return new java.util.Date(fecha_compra.getTimeInMillis());
    }

    public java.sql.Date getFecha_compra_sql() {
        return new java.sql.Date(fecha_compra.getTimeInMillis());
    }

    public void setFecha_compra(GregorianCalendar fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecha_compra=" + format(fecha_compra) + ", id_cliente=" + id_cliente + '}';
    }
    
    //Tomas: este método estaría mejor en una clase de utilidades (controlador)
    public String format(GregorianCalendar calendar) {
        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }


    public void setFecha_compra_date(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        this.setFecha_compra(calendar);
    }
}
