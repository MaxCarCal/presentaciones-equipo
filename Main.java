import javax.swing.SwingUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // 1. Crear la base de datos y tabla si no existen
        crearBaseDeDatos();

        // 2. Iniciar el formulario
        SwingUtilities.invokeLater(() -> {
            new FormularioGeneral().setVisible(true);
        });
    }

    private static void crearBaseDeDatos() {
        String url = "jdbc:sqlite:lib/datos_incidentes.db";
        String sql = "CREATE TABLE IF NOT EXISTS formularios (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "tipo TEXT NOT NULL," +
                     "fecha TEXT NOT NULL," +
                     "hora TEXT NOT NULL," +
                     "ubicacion TEXT NOT NULL," +
                     "descripcion TEXT" +
                     ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✔ Base de datos y tabla listas.");
        } catch (SQLException e) {
            System.err.println("❌ Error al crear la base de datos: " + e.getMessage());
        }
    }
}