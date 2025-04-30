import java.sql.Connection;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS encuestas ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "lugar TEXT,"
                   + "hora TEXT,"
                   + "fecha TEXT,"
                   + "testigos TEXT,"
                   + "numero_personas TEXT,"
                   + "arma TEXT,"
                   + "danos TEXT,"
                   + "denuncia TEXT,"
                   + "descripcion TEXT"
                   + ");";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'encuestas' creada o ya existente.");
        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
} 