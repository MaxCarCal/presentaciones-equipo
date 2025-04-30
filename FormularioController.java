import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FormularioController {
    private FormularioBase formulario;
    
    public FormularioController(FormularioBase formulario) {
        this.formulario = formulario;
        
        formulario.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        
        formulario.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }
    
    private void guardarDatos() {
        if (formulario.txtLugar.getText().trim().isEmpty() || 
            formulario.txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.");
            return;
        }
    
        try (Connection conn = ConexionDB.conectar()) {
            if (conn != null) {
                String sql = "INSERT INTO encuestas (lugar, hora, fecha, testigos, numero_personas, arma, danos, denuncia, descripcion) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, formulario.txtLugar.getText());
                pstmt.setString(2, (String) formulario.cmbHora.getSelectedItem());
                pstmt.setString(3, formulario.txtFecha.getText());
                pstmt.setString(4, (String) formulario.cmbTestigos.getSelectedItem());
                pstmt.setString(5, formulario.txtNumeroPersonas.getText());
                pstmt.setString(6, (String) formulario.cmbArma.getSelectedItem());
                pstmt.setString(7, formulario.txtDanos.getText());
                pstmt.setString(8, formulario.txtDenuncia.getText());
                pstmt.setString(9, formulario.txtDescripcion.getText());
    
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente en la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage());
        }
    }
    
    private void limpiarCampos() {
        formulario.txtLugar.setText("");
        formulario.txtDescripcion.setText("");
        formulario.cmbHora.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "Campos limpiados.");
    }

    private boolean esFechaValida(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
} 

