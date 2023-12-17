package View;

import Model.Cliente;
import Model.MError;
import Model.MiExcepcion;

import javax.swing.*;

public class Login extends JDialog {
    private JButton btn_login;
    private JTextField tf_usuario;
    private JLabel lbl_login;
    private JButton btn_salir;
    private JPasswordField pf_contrasenia;
    private JPanel panel1;
    
    public Login(JFrame parent) {
        super(parent, "Iniciar Sesion",true);
        setContentPane(panel1);

        btn_login.addActionListener(e -> {
            try {
                Init.cliente = new Controller.ClienteLogin(tf_usuario.getText(), String.valueOf(pf_contrasenia.getPassword())).getCliente();
                this.setVisible(false);
                this.dispose();
            } catch (MiExcepcion mie) {
                JOptionPane.showMessageDialog(null, MError.getMensaje(mie.getCodigo()));
            }
        });
    }
}
