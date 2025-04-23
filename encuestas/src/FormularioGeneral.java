import javax.swing.*;

public class FormularioGeneral {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] opciones = {"Robo de Autopartes", "Asalto", "Secuestro"};
            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de incidente:",
                "Tipo de Reporte",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            
            FormularioBase formulario = null;
            if (seleccion != null) {
                switch (seleccion) {
                    case "Robo de Autopartes":
                        formulario = new FormularioAutopartes();
                        break;
                    case "Asalto":
                        formulario = new FormularioAsalto();
                        break;
                    case "Secuestro":
                        formulario = new FormularioSecuestro();
                        break;
                }
                
                if (formulario != null) {
                    new FormularioController(formulario);
                }
            }
        });
    }
}
