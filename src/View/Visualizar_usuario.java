package View;

import Model.Cliente;

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
    private ImageIcon imagen;
    private Cliente cliente;

    public Visualizar_usuario() {
        tf_id.setEditable(false);
        tf_nombre.setEditable(false);
        tf_total.setEditable(false);
        
        imagen = new ImageIcon("src/Images/1001.jpg");
        JLabel imageLabel = new JLabel(imagen);
        jp_image.setLayout(new BorderLayout());
        jp_image.add(imageLabel, BorderLayout.CENTER);
        
        btn_cambiaPass.addActionListener(e -> {
            
        });
    }
}
