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
    private JLabel jimage;
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
        } else {
            imagen = new ImageIcon("src/Images/icon.png");
        }

        jp_image.setLayout(new BorderLayout());
        jimage = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen.getImage(), 0, 0, 150, 150, this);
            }
        };

        jp_image.add(jimage);

        btn_cambiaPass.addActionListener(e -> {
            cbd.actualizarContrasenia(cliente);
        });
    }
}
