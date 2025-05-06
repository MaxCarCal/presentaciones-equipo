import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MapaFrame extends JFrame {
    private static final String DB_URL = "jdbc:sqlite:banco_de_dados.db";
    private String zonaAtual;

    public MapaFrame(String zona) {
        this.zonaAtual = zona;
        
        setTitle("Mapa de Puebla - " + zona);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label com a zona atual
        JLabel lblZona = new JLabel("Zona actual: " + zona, SwingConstants.CENTER);
        lblZona.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblZona, BorderLayout.NORTH);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        
        JButton btnRegistrar = new JButton("Registrar Visita");
        btnRegistrar.addActionListener(e -> {
            registrarAcao("visita_zona");
            JOptionPane.showMessageDialog(this, "Visita registrada en: " + zona);
        });

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> {
            new SeleccionZonaFrame().setVisible(true);
            dispose();
        });

        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnVolver);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void registrarAcao(String acao) {
        String sql = "INSERT INTO mapap (zona, acao) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, zonaAtual);
            pstmt.setString(2, acao);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}