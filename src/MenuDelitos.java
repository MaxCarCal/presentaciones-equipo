import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDelitos extends JFrame {
    private JComboBox<String> comboDelitos;

    public MenuDelitos() {
        setTitle("Selección de Delitos");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] delitos = {"Robo de autopartes", "Asalto", "Secuestro", "Todos"};
        comboDelitos = new JComboBox<>(delitos);
        JButton btnMostrarMapa = new JButton("Mostrar Mapa");

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(new JLabel("Seleccione tipo de delito:"));
        panel.add(comboDelitos);
        panel.add(btnMostrarMapa);

        btnMostrarMapa.addActionListener(e -> mostrarMapa());
        
        add(panel);
        setVisible(true);
    }

    private void mostrarMapa() {
        String seleccion = (String) comboDelitos.getSelectedItem();
        
        // Simular falta de datos para Secuestro
        if(seleccion.equals("Secuestro")) {
            JOptionPane.showMessageDialog(this, "No hay datos disponibles para esta categoría", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        new MapaInterfaz(seleccion).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuDelitos());
    }
}

class MapaInterfaz extends JFrame {
    public MapaInterfaz(String categoria) {
        setTitle("Mapa de Delitos - " + categoria);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        try {
            ImageIcon iconMapa = new ImageIcon(getClass().getResource("/resources/MapaPuebla.jpg"));
            JLabel lblMapa = new JLabel(iconMapa);
            
            JScrollPane scrollPane = new JScrollPane(lblMapa);
            add(scrollPane, BorderLayout.CENTER);
            
            // Simular segmentación (aquí deberías implementar tu lógica real)
            JLabel lblInfo = new JLabel("Mostrando áreas para: " + categoria);
            add(lblInfo, BorderLayout.SOUTH);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el mapa", 
                "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
}