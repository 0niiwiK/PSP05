package View;

import Controller.DataBase;
import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;

import javax.swing.*;
import java.sql.SQLException;

public class Init {
    private JPanel panel1;
    private JButton btn_validar;
    private JButton btn_visualizar;
    private JButton btn_acerca;
    private Cliente cliente = null;
    
    public Init() {
        try {
            DataBase.iniciar();
            DataBase.cargarDatos();
        } catch (MiExcepcion e) {
            JOptionPane.showMessageDialog(null, MError.getMensaje(e.getCodigo()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        btn_validar.setText("Validar");
        btn_visualizar.setText("Visualizar");
        btn_acerca.setText("Acerca de...");
        btn_visualizar.setEnabled(false);
        
        
        btn_validar.addActionListener(e -> {
            Cliente[] cliente1 = new Cliente[1];
            cliente1[0] = null;
            Login frame = new Login(cliente1);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 250);
            frame.setVisible(true);
            cliente = cliente1[0];
            if (this.cliente != null) {
                btn_visualizar.setEnabled(true);
            }
        });
        
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Elija una opción");
        frame.setContentPane(new Init().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
    
    
}
