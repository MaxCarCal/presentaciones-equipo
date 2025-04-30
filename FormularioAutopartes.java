import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormularioAutopartes extends FormularioBase {
    private JTextField txtTipoVehiculo, txtPiezasRobadas;
    
    public FormularioAutopartes() {
        super("Reporte de Robo de Autopartes");
        
        add(new JLabel("Tipo de vehículo:"));
        txtTipoVehiculo = new JTextField();
        add(txtTipoVehiculo);
        
        add(new JLabel("Piezas robadas:"));
        txtPiezasRobadas = new JTextField();
        add(txtPiezasRobadas);
        
        revalidate();
        repaint();
    }
} 
