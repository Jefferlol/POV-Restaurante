
import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false); // Hacer transparente el fondo
        setFocusPainted(false); // Sin borde al enfocar
        setBorderPainted(false); // Sin borde
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        repaint(); // Para redibujar el botón al cambiar el color
    }
}
