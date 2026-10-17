package src.pc;

import java.awt.Color; // Permite crear colores HTML
import java.awt.Font; // Permite crear fuentes
import javax.swing.JFrame; // Ventana en swing
import javax.swing.JLabel; // Permite crear textos o labels
import src.pc.window.screen;

public class sotenglish { // Archivo principal, gestiona los puntos, el titulo y la pantalla actual
    public static float current_screen = 1.0f; // Usado para saber en que ventana se encuentra
    public static int level; // Nivel de dificultad 1 = B2, 2 = C1 y 3 = C2
    public static int pts = 0; // Puntos
    public static boolean pts_set = false;
    public static JLabel titulo = new JLabel("Sotenglish");
    public static JLabel pts_text = new JLabel("Puntos: " + pts);
    private static screen aScreen = null; // Actual Screen; gestiona todas las posibles ventanas
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Sotenglish");
        ventana.setSize(600, 400);
        ventana.setLayout(null); // Permite seleccionar donde se posiciona cada cosa
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null); // Hace que la ventana se inicie en el centro de la pantalla
        ventana.getContentPane().setBackground(new Color(28, 30, 36)); // Le pone un color al fondo (Funciona por RGB)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        titulo.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        titulo.setForeground(Color.WHITE); // Cambio el color de las letras y uso uno de los predefinidos por la libreria color
        titulo.setBounds((600 - 250) / 2, 5, 250, 62); // X, Y, Ancho y Alto (La formula de la X es ancho de la ventana menos ancho del texto entre 2 para que salga centrado)

        pts_text.setFont(new Font("Arial", Font.PLAIN, 12));
        pts_text.setForeground(Color.WHITE);
        pts_text.setBounds(525, 5, 250, 30);
        pts_text.setOpaque(false);

        ventana.add(titulo);
            
        ventana.setVisible(true);
        
        aScreen = new screen(ventana);
        aScreen.update();
    }
}
