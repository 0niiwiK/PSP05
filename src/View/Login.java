package View;

import javax.swing.*;

public class Login extends JDialog{
    private JButton btn_login;
    private JTextField tf_usuario;
    private JLabel lbl_login;
    private JButton btn_salir;
    private JPasswordField pf_contraseña;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Init");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
