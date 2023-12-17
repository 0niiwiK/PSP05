package Model;

import Controller.DataBase;
import Controller.ProductoBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Cliente {
    private int id = 0;
    private String user;
    private float gastoTotal;
    private String password;

    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(float gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
