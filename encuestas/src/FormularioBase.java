import java.awt.*;
import javax.swing.*;

public class FormularioBase extends JFrame {
    protected JTextField txtLugar, txtDescripcion;
    protected JComboBox<String> cmbHora;
    protected JButton btnGuardar, btnLimpiar;
    protected JComboBox<String> cmbArma, cmbTestigos;
    protected JTextField txtFecha, txtNumeroPersonas, txtDanos, txtDenuncia;
    
    public FormularioBase(String titulo) {
        setTitle(titulo);
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));
        
        // Componentes comunes
        add(new JLabel("Lugar del incidente:"));
        txtLugar = new JTextField();
        add(txtLugar);
        
        add(new JLabel("Hora del incidente:"));
        cmbHora = new JComboBox<>(new String[]{"Mañana", "Tarde", "Noche"});
        add(cmbHora);
        
        add(new JLabel("Fecha del incidente:"));
        txtFecha = new JTextField();
        add(txtFecha);
        
        add(new JLabel("¿Hubo testigos?"));
        cmbTestigos = new JComboBox<>(new String[]{"Sí", "No"});
        add(cmbTestigos);
        
        add(new JLabel("¿Cuántas personas estaban involucradas?"));
        txtNumeroPersonas = new JTextField();
        add(txtNumeroPersonas);
        
        add(new JLabel("¿Hubo uso de armas?"));
        cmbArma = new JComboBox<>(new String[]{"Sí", "No"});
        add(cmbArma);
        
        add(new JLabel("¿Se reportaron daños materiales?"));
        txtDanos = new JTextField();
        add(txtDanos);
        
        add(new JLabel("¿Se presentó una denuncia?"));
        txtDenuncia = new JTextField();
        add(txtDenuncia);
        
        add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        add(txtDescripcion);
        
        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        add(btnGuardar);
        add(btnLimpiar);
        
        setVisible(true);
    }
}

