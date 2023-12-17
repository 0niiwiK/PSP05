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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Init");
        frame.setContentPane(new Init().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
