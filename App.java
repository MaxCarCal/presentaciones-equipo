import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SeleccionZonaFrame frame = new SeleccionZonaFrame();
            frame.setVisible(true);
        });
    }
}