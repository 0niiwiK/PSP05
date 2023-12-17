package View;

import javax.swing.*;

public class Login extends JDialog {
    private JButton btn_login;
    private JTextField tf_usuario;
    private JLabel lbl_login;
    private JButton btn_salir;
    private JPasswordField pf_contraseña;
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Log In");
        frame.setContentPane(new Login().panel1);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
