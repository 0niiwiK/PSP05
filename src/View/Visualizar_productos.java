package View;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.*;

public class Visualizar_productos {
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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private final JDateChooser dateChooser = new JDateChooser();
    
    public Visualizar_productos() {
        jp_fecha.setLayout(new BorderLayout());
        dateChooser.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
        jp_fecha.add(dateChooser, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualizar productos");
        frame.setContentPane(new Visualizar_productos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
