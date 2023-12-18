package View;

import Controller.ClienteBD;
import Model.Cliente;
import Model.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Visualizar_usuario extends JDialog {
    private JButton btn_cambiaPass;
    private JTextField tf_total;
    private JTextField tf_nombre;
    private JTextField tf_id;
    private JPanel jpanel1;
    private JPanel jp_image;
    private JLabel lbl_id;
    private JList list_usuario;
    private JScrollPane scrollPane;
    private ImageIcon imagen;
    private Cliente cliente;
    private DefaultListModel<String> listModel;
    private ClienteBD cbd;

    public Visualizar_usuario(JFrame parent) {
        super(parent, "Visualizar Usuario",true);
        tf_id.setEditable(false);
        tf_nombre.setEditable(false);
        tf_total.setEditable(false);
        cliente = Init.cliente;
        setContentPane(jpanel1);
        tf_id.setText(String.valueOf(cliente.getId()));
        tf_nombre.setText(cliente.getUser());
        tf_total.setText(String.valueOf(cliente.getGastoTotal()));

        cbd = new ClienteBD(cliente.getId());
        ArrayList<Producto> lista_productos = cbd.getProductos();
        listModel = new DefaultListModel<>();
        listModel.addAll(lista_productos.stream().map(Producto::getListItem).toList());
        list_usuario.setModel(listModel);
        
        if (cliente.getImagen() != null) {
            imagen = new ImageIcon(cliente.getImagen());
            JLabel imageLabel = new JLabel(imagen);
            jp_image.setLayout(new BorderLayout());
            jp_image.add(imageLabel, BorderLayout.CENTER);
        }else {
            imagen = new ImageIcon("src/Images/icon.png");
            JLabel imageLabel = new JLabel(imagen);
            jp_image.setLayout(new BorderLayout());
            jp_image.add(imageLabel, BorderLayout.CENTER);
        }
        
        
        
        btn_cambiaPass.addActionListener(e -> {
            
        });
    }
    
    public void cambiaPass() {
        
    }
}
