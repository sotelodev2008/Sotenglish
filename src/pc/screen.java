package src.pc.window;

import javax.swing.JFrame;
import src.pc.sotenglish;

public class screen {
    JFrame ventana;
    public screen(JFrame empty_ventana) {
        this.ventana = empty_ventana;
    }
    public void update() {
        if (sotenglish.current_screen == 1.0f) {
            level_selector lvl_select = new level_selector(ventana); 
            lvl_select.lvl_select_screen();
        }
        else if (sotenglish.current_screen == 2.1f || sotenglish.current_screen == 2.2f || sotenglish.current_screen == 2.3f) {
            rephrasal ejercicio = new rephrasal();
            ventana.getContentPane().removeAll();
            ventana.add(sotenglish.titulo);
            ventana.add(sotenglish.pts_text);
            ejercicio.ejercicio(ventana);
            System.out.println("¡Éxito! Estamos en la pantalla del nivel B2");
        }

        ventana.getContentPane().revalidate();
        ventana.getContentPane().repaint();
    }
}
