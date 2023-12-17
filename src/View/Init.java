package View;

import Controller.DataBase;
import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;

import javax.swing.*;
import java.sql.SQLException;

public class Init extends JFrame {
    private JPanel panel1;
    private JButton btn_validar;
    private JButton btn_visualUsu;
    private JButton btn_acerca;
    private JButton btn_visualProd;
    protected static Cliente cliente = null;
    
    public Init() {
        try {
            DataBase.iniciar();
            DataBase.cargarDatos();
        } catch (MiExcepcion e) {
            JOptionPane.showMessageDialog(null, MError.getMensaje(e.getCodigo()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        btn_visualUsu.setEnabled(false);
        btn_visualProd.setEnabled(false);
        
        btn_validar.addActionListener(e -> {
            showLogin();
        });
        
        btn_visualUsu.addActionListener(e -> {
            
        });
        
        btn_visualProd.addActionListener(e -> {
            showProductos();
        });
    }

    private void showProductos() {
        Visualizar_productos frame = new Visualizar_productos(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }

    private void showLogin() {
        Login frame = new Login(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
        if (cliente != null) {
            btn_visualUsu.setEnabled(true);
            btn_visualProd.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Elija una opción");
        frame.setContentPane(new Init().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
    
    
}
