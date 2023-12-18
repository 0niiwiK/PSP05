package View;

import Controller.DataBase;
import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

public class Init extends JFrame implements WindowListener {
    private JPanel panel1;
    private JButton btn_validar;
    private JButton btn_visualUsu;
    private JButton btn_acerca;
    private JButton btn_visualProd;
    protected static Cliente cliente = null;
    
    public Init() {
        
        btn_visualUsu.setEnabled(false);
        btn_visualProd.setEnabled(false);
        
        btn_validar.addActionListener(e -> {
            if (cliente == null) {
                if (prepararBD())
                    showLogin();
            } else
                logout();
        });
        
        btn_visualUsu.addActionListener(e -> {
            showUsuario();
        });
        
        btn_visualProd.addActionListener(e -> {
            showProductos();
        });

        btn_acerca.addActionListener(e -> {
            showAcerca();
        });
    }

    private void showAcerca() {
        JDialog dialogo = new JDialog(this, "Acerca de", true);

        JLabel label = new JLabel("Autores:");
        JLabel label4 = new JLabel("Daniel Rosales");
        JLabel label5 = new JLabel("Israel Sánchez");
        JLabel label2 = new JLabel("Fecha de creacion: 12/12/2022");
        JLabel label3 = new JLabel("Version: 1.0.2");
        JButton aceptarButton = new JButton("Aceptar");

        aceptarButton.addActionListener(e -> {
            dialogo.dispose();
        });

        // Diseño del JDialog
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(label);
        panel.add(label4);
        panel.add(label5);
        panel.add(label2);
        panel.add(label3);
        panel.add(aceptarButton);

        dialogo.getContentPane().add(panel);
        dialogo.setSize(200, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setResizable(false);

        // Mostrar el JDialog modal
        dialogo.setVisible(true);
    }

    private Boolean prepararBD() {
        try {
            DataBase.iniciar();
            return true;
        } catch (MiExcepcion e) {
            JOptionPane.showMessageDialog(null, MError.getMensaje(e.getCodigo()));
        }
        return false;
    }

    private void logout() {
        cliente = null;
        btn_visualUsu.setEnabled(false);
        btn_visualProd.setEnabled(false);
        btn_validar.setText("Iniciar Sesión");
    }

    private void showUsuario() {
        /*Visualizar_usuario frame = new Visualizar_usuario(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);*/
    }

    private void showProductos() {
        Visualizar_productos frame = new Visualizar_productos(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 250);
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
            btn_validar.setText("Cerrar Sesión");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Elija una opción");
        frame.setContentPane(new Init().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            DataBase.cerrar();
            System.exit(0);
        } catch (MiExcepcion ex) {
            JOptionPane.showMessageDialog(null, MError.getMensaje(ex.getCodigo()));
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
