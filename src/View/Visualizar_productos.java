package View;

import Controller.ProductoBD;
import Model.Cliente;
import Model.Producto;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizar_productos extends JDialog {
    private JButton btn_anterior;
    private JButton btn_siguiente;
    private JButton btn_modificar;
    private JButton btn_salir;
    private JLabel lbl_id;
    private JLabel lbl_nom;
    private JLabel lbl_precio;
    private JPanel jp_fecha;
    private JLabel lbl_tit;
    private JPanel panel1;
    private JTextField tf_id;
    private JTextField tf_nombre;
    private JTextField tf_precio;
    private final JDateChooser dateChooser = new JDateChooser();
    private Cliente cliente;
    private ProductoBD pbd;
    
    public Visualizar_productos (JFrame parent) {
        super(parent, "Visualizar productos",true);
        cliente = Init.cliente;
        setContentPane(panel1);
        jp_fecha.setLayout(new BorderLayout());
        dateChooser.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
        jp_fecha.add(dateChooser, BorderLayout.CENTER);

        pbd = new ProductoBD(cliente.getId());

        if (pbd.esVacio()) {
            bloquear();
        } else {
            pbd.siguiente();
            mostrar();
        }

        btn_anterior.addActionListener(e -> {
            if (pbd.anterior())
                mostrar();
        });

        btn_siguiente.addActionListener(e -> {
            if (pbd.siguiente())
                mostrar();
        });

        btn_salir.addActionListener(e -> {
            pbd.cerrar();
            this.setVisible(false);
            this.dispose();
        });

        btn_modificar.addActionListener(e -> {
            modificar();
        });
        
    }

    private void modificar() {
        Producto p = pbd.leer();
        p.setFecha_compra_date(dateChooser.getDate());
        pbd.update(p);
    }

    private void mostrar() {
        Producto p = pbd.leer();
        tf_id.setText(String.valueOf(p.getId()));
        tf_id.setEditable(false);
        tf_nombre.setText(p.getNombre());
        tf_nombre.setEditable(false);
        dateChooser.setDate(p.getFecha_compra_date());
        tf_precio.setText(String.valueOf(p.getPrecio()));
        tf_precio.setEditable(false);
        btn_anterior.setEnabled(!pbd.esPrimero());
        btn_siguiente.setEnabled(!pbd.esUltimo());
        btn_modificar.setEnabled(true);
    }

    private void bloquear() {
        dateChooser.setEnabled(false);
        btn_anterior.setEnabled(false);
        btn_siguiente.setEnabled(false);
        btn_modificar.setEnabled(false);
    }
}
