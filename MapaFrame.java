import javax.swing.*;
<<<<<<< HEAD
import java.sql.*;

public class MapaFrame extends JFrame {
    private String zonaSelecionada;
    
    public MapaFrame(String zonaSelecionada) {
        this.zonaSelecionada = zonaSelecionada;
        
        setTitle("Mapa de Puebla - Zona: " + zonaSelecionada);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel zonaLabel = new JLabel("Você está visualizando: " + zonaSelecionada);
        add(zonaLabel);

        
        JButton gravarBotao = new JButton("Gravar Interação");
        gravarBotao.addActionListener(e -> {
            String data = "2025-04-16"; 
            String descricao = "Interação no mapa de Puebla - Zona: " + zonaSelecionada;
            String tipo = "Consulta";
            String usuario = "Lucas"; 
            inserirInteracao(data, descricao, tipo, usuario);
        });
        add(gravarBotao);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }
    
    public static void inserirInteracao(String data, String descricao, String tipo, String usuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco_de_dados.db")) {
            String sql = "INSERT INTO interacoes (data, descricao, tipo, usuario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, data);
                statement.setString(2, descricao);
                statement.setString(3, tipo);
                statement.setString(4, usuario);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
=======
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
>>>>>>> ee49fee1c12aed07cf89a3dff38104bb261ea20f
