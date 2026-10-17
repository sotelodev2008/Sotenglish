package src.pc.window;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.pc.sotenglish;

public class results {
    private String enunciado;
    private String inicio;
    private String sol;
    private String desenlace;
    JFrame ventana;
    public results(String enunciado, String inicio, String sol, String desenlace, JFrame ventana){
        this.enunciado = enunciado;
        this.inicio = inicio;
        this.sol = sol;
        this.desenlace = desenlace;
        this.ventana = ventana;
    }

    public void results_chooser(boolean[] tabien){ // Compruebo que tal lo ha hecho y muestro la pantalla de resultados
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();

        JLabel enunciado_text = new JLabel(enunciado);
        enunciado_text.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        enunciado_text.setForeground(Color.WHITE);
        enunciado_text.setSize(enunciado_text.getPreferredSize().width, 30); // Le da el tamaño que necesite width
        enunciado_text.setLocation((600 - enunciado_text.getWidth()) / 2, 80);

        JLabel sol_text = new JLabel(inicio + " " + sol + " " + desenlace);
        sol_text.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sol_text.setForeground(Color.WHITE);
        sol_text.setSize(sol_text.getPreferredSize().width, 30);
        sol_text.setLocation((600 - sol_text.getWidth()) / 2, 110);

        JButton continue_button = new JButton("Continuar");
        continue_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        continue_button.setForeground(Color.BLACK);
        continue_button.setSize(continue_button.getPreferredSize());
        continue_button.setLocation(270, 150); // Pongo las posiciones manualmente por fallos
        continue_button.setBackground(new Color(255, 239, 35)); // To reach the unreachable star! (Sinner 3)
        continue_button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        continue_button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        continue_button.setOpaque(true);
        continue_button.addActionListener(e -> MerryGoRound());

        JButton lvl_button = new JButton("Cambiar dificultad");
        lvl_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lvl_button.setForeground(Color.BLACK);
        lvl_button.setSize(lvl_button.getPreferredSize());
        lvl_button.setLocation(55, 150); // Pongo las posiciones manualmente por fallos
        lvl_button.setBackground(new Color(255, 149, 0)); // Alright, bets on the table. (Sinner 8)
        lvl_button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        lvl_button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        lvl_button.setOpaque(true);
        lvl_button.addActionListener(e -> lvl_change());
        
        JButton exit_button = new JButton("Salir");
        exit_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exit_button.setForeground(Color.WHITE);
        exit_button.setSize(exit_button.getPreferredSize());
        exit_button.setLocation(410, 150); // Pongo las posiciones manualmente por fallos
        exit_button.setBackground(new Color(41, 59, 149)); // The gaze of another nails into me, driving a hollow from which multitudes spill forth. (Sinner 5)
        exit_button.setFocusPainted(false);       // Quita el borde de enfoque parpadeante
        exit_button.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        exit_button.setOpaque(true);
        exit_button.addActionListener(e -> System.exit(0));

        ventana.add(sotenglish.titulo);
        ventana.add(sotenglish.pts_text);
        ventana.add(enunciado_text);
        ventana.add(sol_text);
        ventana.add(continue_button);
        ventana.add(lvl_button);
        ventana.add(exit_button);
        if (tabien[0] && tabien[1]){alright();}
        else if (tabien[0] || tabien[1]){meh(enunciado_text, sol_text);}
        else{bad_ending();}
    }

    private void alright(){ // lo ha hecho bien
        ventana.getContentPane().setBackground(new Color(34, 139, 34));
    }

    private void meh(JLabel enunciado_text, JLabel sol_text){ // lo ha hecho regular
        sotenglish.titulo.setForeground(Color.BLACK);
        sotenglish.pts_text.setForeground(Color.BLACK);
        enunciado_text.setForeground(Color.BLACK);
        sol_text.setForeground(Color.WHITE);
        ventana.getContentPane().setBackground(new Color(253, 218, 13));
    }
    
    private void bad_ending(){ // lo ha hecho mal
        ventana.getContentPane().setBackground(new Color(196, 30, 58));
    }

    private void MerryGoRound(){ // Repetimos
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        sotenglish.titulo.setForeground(Color.WHITE);
        sotenglish.pts_text.setForeground(Color.WHITE);
        ventana.add(sotenglish.titulo);
        ventana.add(sotenglish.pts_text);
        ventana.getContentPane().setBackground(new Color(28, 30, 36));
        rephrasal repetir = new rephrasal();
        repetir.ejercicio(ventana);
    }

    private void lvl_change(){ // Cambiar de nivel
        ventana.getContentPane().removeAll();
        ventana.revalidate();
        ventana.repaint();
        sotenglish.titulo.setForeground(Color.WHITE);
        sotenglish.pts_text.setForeground(Color.WHITE);
        ventana.add(sotenglish.titulo);
        ventana.add(sotenglish.pts_text);
        ventana.getContentPane().setBackground(new Color(28, 30, 36));
        sotenglish.current_screen = 1.0f;
        screen pantalla = new screen(ventana);
        pantalla.update();
    }
}
