import javax.swing.*;
import java.awt.*;

public class MapaFrame extends JFrame {
    public MapaFrame(String zona) {
        setTitle("Mapa de Puebla - " + zona);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblZona = new JLabel("Zona seleccionada: " + zona, SwingConstants.CENTER);
        panel.add(lblZona, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        panel.add(btnVolver, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> {
            new SeleccionZonaFrame();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}