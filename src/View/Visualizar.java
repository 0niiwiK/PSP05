package View;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.*;

public class Visualizar extends JDialog {
    private JButton btn_anterior;
    private JButton btn_siguiente;
    private JButton btn_modificar;
    private JButton btn_salir;
    private JLabel lbl_id;
    private JLabel lbl_nom;
    private JLabel lbl_precio;
    private JPanel jp_fecha;
    private JLabel lbl_tit;
    private final JDateChooser dateChooser = new JDateChooser();
    
    public Visualizar() {
        jp_fecha.setLayout(new BorderLayout());
        dateChooser.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
        jp_fecha.add(dateChooser, BorderLayout.CENTER);
    }
}
