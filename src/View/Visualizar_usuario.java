package View;

import javax.swing.*;
import java.awt.*;

public class Visualizar_usuario {
    private JButton btn_cambiaPass;
    private JTextField tf_total;
    private JTextField tf_nombre;
    private JTextField tf_id;
    private JPanel jpanel1;
    private JPanel jp_image;
    private JLabel lbl_id;
    private JTextField textField1;

    public Visualizar_usuario() {
        tf_id.setEditable(false);
        
        jp_image.setLayout(new BorderLayout());
        jp_image.add(tf_id, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualizar_usuario");
        frame.setContentPane(new Visualizar_usuario().jpanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
