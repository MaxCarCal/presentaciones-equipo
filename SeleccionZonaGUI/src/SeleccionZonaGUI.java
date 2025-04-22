import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SeleccionZonaGUI {
    private JFrame frame;
    private JComboBox<String> comboZonas;
    private JLabel labelMapa;
    private HashMap<String, String> mapasDisponibles;

    public SeleccionZonaGUI() {
        frame = new JFrame("Selección de Zona");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Lista de zonas
        String[] zonas = {"Cholula", "Cuautlancingo", "Central de Abastos", "Parque Industrial", "La Paz", "San Baltazar Campeche", "Angelopolis", "Zona sin mapa"};
        comboZonas = new JComboBox<>(zonas);
        JButton btnMostrar = new JButton("Mostrar Mapa");
        labelMapa = new JLabel("Mapa: [Selecciona una zona]");

        // Simulación de rutas de mapas
        mapasDisponibles = new HashMap<>();
        mapasDisponibles.put("Cholula", "mapa_cholula.png");
        mapasDisponibles.put("Cuautlancingo", "mapa_cuautlancingo.png");
        mapasDisponibles.put("Central de Abastos", "mapa_abastos.png");
        mapasDisponibles.put("Parque Industrial", "mapa_industrial.png");
        mapasDisponibles.put("La Paz", "mapa_paz.png");
        mapasDisponibles.put("San Baltazar Campeche", "mapa_sanbaltazar.png");
        mapasDisponibles.put("Angelopolis", "mapa_angelopolis.png");
        // "Zona sin mapa" no tiene entrada en el HashMap

        // Acción del botón
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zonaSeleccionada = (String) comboZonas.getSelectedItem();
                mostrarMapa(zonaSeleccionada);
            }
        });

        frame.add(comboZonas);
        frame.add(btnMostrar);
        frame.add(labelMapa);
        frame.setVisible(true);
    }

    private void mostrarMapa(String zona) {
        String rutaMapa = mapasDisponibles.get(zona);

        if (rutaMapa == null) { // Si la zona no tiene un mapa disponible
            JOptionPane.showMessageDialog(frame, "El mapa de la zona seleccionada no está disponible.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            labelMapa.setText("Mapa: " + rutaMapa); // Simulación de mostrar el mapa
        }
    }

    public static void main(String[] args) {
        new SeleccionZonaGUI();
    }
}
