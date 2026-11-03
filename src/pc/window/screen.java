package src.pc.window;

import javax.swing.JFrame;
import src.pc.Sotenglish;

public class Screen {
    JFrame ventana;
    public Screen(JFrame empty_ventana) {
        this.ventana = empty_ventana;
    }
    public void update() {
        if (Sotenglish.current_screen == 1.0f) {
            LevelSelector lvl_select = new LevelSelector(ventana); 
            lvl_select.lvl_select_screen();
        }
        else if (Sotenglish.current_screen == 2.1f || Sotenglish.current_screen == 2.2f || Sotenglish.current_screen == 2.3f) {
            Rephrasal ejercicio = new Rephrasal();
            ventana.getContentPane().removeAll();
            ventana.add(Sotenglish.titulo);
            ventana.add(Sotenglish.pts_text);
            ejercicio.ejercicio(ventana);
            System.out.println("¡Éxito! Estamos en la pantalla del nivel B2");
        }

        ventana.getContentPane().revalidate();
        ventana.getContentPane().repaint();
    }
}
