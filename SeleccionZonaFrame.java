import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeleccionZonaFrame extends JFrame {
    private JComboBox<String> comboBox;
    private JButton selecionarButton;

    public SeleccionZonaFrame() {
        
        setTitle("Selecione a Zona");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        String[] zonas = { "Centro Histórico", "Zona Arqueológica", "Catedral de Puebla", "Cholula" };
        comboBox = new JComboBox<>(zonas);
        
        
        selecionarButton = new JButton("Selecionar");
        selecionarButton.addActionListener(e -> {
            String zonaSelecionada = comboBox.getSelectedItem().toString();
            MapaFrame mapa = new MapaFrame(zonaSelecionada);
            mapa.setVisible(true);
            dispose(); 
        });

        
        setLayout(new FlowLayout());
        add(new JLabel("Escolha uma Zona:"));
        add(comboBox);
        add(selecionarButton);
        
        setVisible(true);
    }
}
