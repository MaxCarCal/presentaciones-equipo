import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormularioSecuestro extends FormularioBase {
    private JTextField txtDuracion, txtRescate;
    
    public FormularioSecuestro() {
        super("Reporte de Secuestro");
        
        add(new JLabel("Duración del secuestro (horas/días):"));
        txtDuracion = new JTextField();
        add(txtDuracion);
        
        add(new JLabel("¿Se pidió rescate?"));
        txtRescate = new JTextField();
        add(txtRescate);
        
        revalidate();
        repaint();
    }
}

