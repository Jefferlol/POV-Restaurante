
package imagenes;
import javax.swing.*;
import java.awt.*;

public class images {
    public static void main(String[] args) {
        // Crear un marco (JFrame)
        JFrame frame = new JFrame("Mostrar Imagen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Cargar la imagen
        ImageIcon imagen = new ImageIcon("C:\\Users\\wilia\\Pictures\\imgenes_Res");
        // Crear una etiqueta para mostrar la imagen
        JLabel etiqueta = new JLabel(imagen);
        frame.getContentPane().add(etiqueta); // Añadir la etiqueta al marco
    }
}

