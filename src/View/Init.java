package View;

import javax.swing.*;

public class Init {
    private JPanel panel1;
    private JButton btn_validar;
    private JButton btn_visualizar;
    private JButton btn_acerca;
    
    public Init() {
        btn_validar.setText("Validar");
        btn_visualizar.setText("Visualizar");
        btn_acerca.setText("Acerca de...");
        btn_visualizar.setEnabled(false);
    }
}
