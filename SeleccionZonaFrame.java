import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionZonaFrame extends JFrame {
    private JComboBox<String> zonaComboBox;
    private JButton btnVerMapa, btnSalir;

    public SeleccionZonaFrame() {
        setTitle("Selección de Zona - Mapa de Puebla");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel lblSelecionar = new JLabel("Seleccione una zona:", SwingConstants.CENTER);
        panel.add(lblSelecionar);

        zonaComboBox = new JComboBox<>(new String[]{"Cholula", "Cuautlancingo", "Central de abastos", "Parque industrial", "La paz", "San Baltazar Campeche", "Angelópolis"});
        panel.add(zonaComboBox);

        JPanel btnPanel = new JPanel();
        btnVerMapa = new JButton("Ver Mapa");
        btnSalir = new JButton("Salir");
        btnPanel.add(btnVerMapa);
        btnPanel.add(btnSalir);
        panel.add(btnPanel);

        btnVerMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zonaSeleccionada = (String) zonaComboBox.getSelectedItem();
                new OpcionesZonaFrame(zonaSeleccionada); // Abre a nova janela com opções específicas
                dispose(); // Fecha a janela atual
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SeleccionZonaFrame();
    }
}

// Nova classe para exibir opções específicas de cada zona
class OpcionesZonaFrame extends JFrame {
    public OpcionesZonaFrame(String zona) {
        setTitle("Opciones de " + zona);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel lblOpciones = new JLabel("Opciones para " + zona + ":", SwingConstants.CENTER);
        panel.add(lblOpciones);

        // Adiciona opções específicas para cada zona
        switch (zona) {
            case "Cholula":
                agregarBoton(panel, zona, "San Andres");
                agregarBoton(panel, zona, "San Pedro");
                break;
            case "Cuautlancingo":
                agregarBoton(panel, zona, "Manantiales");
                agregarBoton(panel, zona, "Momoxpan");
                break;
            case "Central de abastos":
                agregarBoton(panel, zona, "San Jeronimo");
                agregarBoton(panel, zona, "San Sebastian de Aparicio");
                break;
            case "Parque industrial":
                agregarBoton(panel, zona, "Bosques de San Sebastian");
                agregarBoton(panel, zona, "Encinos");
                break;
            case "La paz":
                agregarBoton(panel, zona, "Santa Cruz Buenavista");
                agregarBoton(panel, zona, "Bello Horizonte");
                break;
            case "San Baltazar Campeche":
                agregarBoton(panel, zona, "La Margarita");
                agregarBoton(panel, zona, "Tres Cruces");
                break;
            case "Angelópolis":
                agregarBoton(panel, zona, "Atlixcayotl");
                agregarBoton(panel, zona, "Chulavista");
                break;
            default:
                panel.add(new JLabel("No hay opciones disponibles para esta zona."));
                break;
        }

        add(panel);
        setVisible(true);
    }

    // Método para adicionar botões com ações
    private void agregarBoton(JPanel panel, String zona, String opcion) {
        JButton boton = new JButton(opcion);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe a zona e a opção selecionada
                JOptionPane.showMessageDialog(OpcionesZonaFrame.this,
                        "Zona: " + zona + "\nOpción seleccionada: " + opcion,
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(boton);
    }
}