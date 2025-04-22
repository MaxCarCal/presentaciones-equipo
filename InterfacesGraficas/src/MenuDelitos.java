import javax.swing.*;
import java.awt.*;

public class MenuDelitos extends JFrame {
    private JComboBox<String> comboDelitos;
    private JComboBox<String> comboAreas;

    public MenuDelitos() {
        setTitle("Selección de Delitos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] delitos = {"Robo de autopartes", "Asalto", "Secuestro", "Todos"};
        comboDelitos = new JComboBox<>(delitos);

        String[] areas = {"A", "B", "C", "Todas"};
        comboAreas = new JComboBox<>(areas);

        JButton btnMostrarMapa = new JButton("Mostrar Mapa");

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(new JLabel("Seleccione tipo de delito:"));
        panel.add(comboDelitos);
        panel.add(new JLabel("Seleccione área:"));
        panel.add(comboAreas);
        panel.add(btnMostrarMapa);

        btnMostrarMapa.addActionListener(e -> mostrarMapa());
        
        add(panel);
        setVisible(true);
    }

    private void mostrarMapa() {
        String delito = (String) comboDelitos.getSelectedItem();
        String area = (String) comboAreas.getSelectedItem();
        new MapaInterfaz(delito, area).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuDelitos());
    }
}

class MapaInterfaz extends JFrame {
    public MapaInterfaz(String delito, String area) {
        setTitle("Mapa de Delitos - " + delito + " / " + area);
        setSize(800, 600);
        setLocationRelativeTo(null);

        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/resources/MapaPuebla.jpg"));
            JLabel lblMapa = new JLabel(icono);
            JScrollPane scrollMapa = new JScrollPane(lblMapa);
            add(scrollMapa, BorderLayout.CENTER);

            JLabel lblInfo = new JLabel("Mostrando mapa para: " + delito + " en área " + area);
            add(lblInfo, BorderLayout.SOUTH);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el mapa", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
}