package src.pc.window;

import java.awt.Color; // Permite crear colores HTML
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import src.pc.sotenglish;

public class level_selector {
    JFrame ventana;
    public level_selector(JFrame ventana) {
        this.ventana = ventana;
    }
    public void lvl_select_screen() {

        sotenglish.pts_set = false;

        JLabel hint = new JLabel("Elige un nivel de dificultad");
        hint.setFont(new Font("Arial", Font.PLAIN, 20));
        hint.setForeground(Color.WHITE);
        hint.setBounds((600 - 250) / 2, 55, 250, 50);
        hint.setOpaque(false);

        JButton B2_Button = new JButton("B2");
        B2_Button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        B2_Button.setForeground(Color.WHITE);
        B2_Button.setSize(B2_Button.getPreferredSize());
        B2_Button.setLocation((600 - B2_Button.getWidth() * 2) / 3, 130);
        B2_Button.setBackground(new Color(130, 0, 0)); // If she could forget everything, and begin afresh. (Sinner 9)
        B2_Button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        B2_Button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        B2_Button.setOpaque(true);
        B2_Button.addActionListener(e -> onButtonClick(1)); // e -> Usa una expresión lambda para definir la función anónima que se ejecuta al pulsar el botón.

        JButton C1_Button = new JButton("C1");
        C1_Button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        C1_Button.setForeground(Color.WHITE);
        C1_Button.setSize(C1_Button.getPreferredSize());
        C1_Button.setLocation((600 - C1_Button.getWidth()) / 2, 130);
        C1_Button.setBackground(new Color(139, 156, 21)); // Meanwhile, the world of evil began there already, right in the middle of our house. (Sinner 11)
        C1_Button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        C1_Button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        C1_Button.setOpaque(true);
        C1_Button.addActionListener(e -> onButtonClick(2));

        JButton C2_Button = new JButton("C2");
        C2_Button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        C2_Button.setForeground(Color.WHITE);
        C2_Button.setSize(C2_Button.getPreferredSize());
        C2_Button.setLocation((600 - C2_Button.getWidth()) * 5 / 7, 130);
        //C2_Button.setBounds((600 - 30) / 3 * 2, 130, 60, 40);
        C2_Button.setBackground(new Color(176, 28, 55)); // All hope abandon ye who enter here. (Sinner 10)
        C2_Button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        C2_Button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        C2_Button.setOpaque(true);
        C2_Button.addActionListener(e -> onButtonClick(3));

        ventana.add(hint);
        ventana.add(B2_Button);
        ventana.add(C1_Button);
        ventana.add(C2_Button);

        ventana.revalidate();
        ventana.repaint();
    }
    public void resultados(){}
    private void onButtonClick(int dificultad) {
        if (dificultad == 1) {
            System.out.println("Hola1");
            sotenglish.current_screen = 2.1f;
            if (!sotenglish.pts_set) {
                sotenglish.pts_set = true;
                if (sotenglish.current_screen == 2.1f) {sotenglish.level = 1;}
                else if (sotenglish.current_screen == 2.2f) {sotenglish.level = 2;}
                else if (sotenglish.current_screen == 2.3f) {sotenglish.level = 3;}
                screen aScreen = new screen(ventana);
                aScreen.update();
            }
        }
        else if (dificultad == 2) {
            System.out.println("Hola2");
            sotenglish.current_screen = 2.2f;
            if (!sotenglish.pts_set) {
                sotenglish.pts_set = true;
                if (sotenglish.current_screen == 2.1f) {sotenglish.level = 1;}
                else if (sotenglish.current_screen == 2.2f) {sotenglish.level = 2;}
                else if (sotenglish.current_screen == 2.3f) {sotenglish.level = 3;}
                screen aScreen = new screen(ventana);
                aScreen.update();
            }
        }
        else if (dificultad == 3) {
            System.out.println("Hola3");
            sotenglish.current_screen = 2.3f;
            if (!sotenglish.pts_set) {
                sotenglish.pts_set = true;
                if (sotenglish.current_screen == 2.1f) {sotenglish.level = 1;}
                else if (sotenglish.current_screen == 2.2f) {sotenglish.level = 2;}
                else if (sotenglish.current_screen == 2.3f) {sotenglish.level = 3;}
                screen aScreen = new screen(ventana);
                aScreen.update();
            }
        }
        System.out.println("Cambiando a pantalla: " + sotenglish.current_screen);
    }
}
