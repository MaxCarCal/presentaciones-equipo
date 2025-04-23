import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
        // Validaciones básicas
        if (formulario.txtLugar.getText().trim().isEmpty() || 
            formulario.txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.");
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        // Aquí puedes agregar la lógica para almacenar la información
    }
    
    private void limpiarCampos() {
        formulario.txtLugar.setText("");
        formulario.txtDescripcion.setText("");
        formulario.cmbHora.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "Campos limpiados.");
    }
}
