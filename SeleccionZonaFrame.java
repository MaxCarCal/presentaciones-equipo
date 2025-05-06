import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SeleccionZonaFrame extends JFrame {
    private JComboBox<String> zonaComboBox;
    private JButton btnVerMapa, btnSalir;
    private static final String DB_URL = "jdbc:sqlite:banco_de_dados.db";

    public SeleccionZonaFrame() {
        criarTabelaMapap(); // Garante que a tabela existe
        
        setTitle("Seleccionar Zona - Mapa Puebla");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ComboBox de zonas
        zonaComboBox = new JComboBox<>(new String[]{
            "Cholula", "Angelópolis", "La Paz", 
            "Central de abastos", "Parque industrial"
        });
        panel.add(zonaComboBox, BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnVerMapa = new JButton("Ver Mapa");
        btnSalir = new JButton("Salir");

        // Ação do botão Ver Mapa
        btnVerMapa.addActionListener(e -> {
            String zona = (String) zonaComboBox.getSelectedItem();
            registrarAcao(zona, "entrada_zona");
            new MapaFrame(zona).setVisible(true);
            dispose();
        });

        // Ação do botão Sair
        btnSalir.addActionListener(e -> System.exit(0));

        buttonPanel.add(btnVerMapa);
        buttonPanel.add(btnSalir);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void criarTabelaMapap() {
        String sql = "CREATE TABLE IF NOT EXISTS mapap (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "data_registro DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                     "zona TEXT NOT NULL, " +
                     "acao TEXT NOT NULL)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void registrarAcao(String zona, String acao) {
        String sql = "INSERT INTO mapap (zona, acao) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, zona);
            pstmt.setString(2, acao);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Error al registrar: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}