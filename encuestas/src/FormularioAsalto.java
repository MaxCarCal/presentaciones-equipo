import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormularioAsalto extends FormularioBase {
    private JComboBox<String> cmbTipoAsalto;
    private JTextField txtObjetoRobado;
    
    public FormularioAsalto() {
        super("Reporte de Asalto");
        
        add(new JLabel("Tipo de asalto:"));
        cmbTipoAsalto = new JComboBox<>(new String[]{"Con violencia", "Sin violencia"});
        add(cmbTipoAsalto);
        
        add(new JLabel("Objeto robado:"));
        txtObjetoRobado = new JTextField();
        add(txtObjetoRobado);
        
        revalidate();
        repaint();
    }
}
