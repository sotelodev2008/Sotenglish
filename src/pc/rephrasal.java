package src.pc.window;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import src.pc.sotenglish;
import src.shared.data;
import src.shared.random;

public class rephrasal {
    public rephrasal(){}
    public void ejercicio(JFrame ventana) {
        data frases = new data(sotenglish.level, ventana);
        random ranum = new random(frases.total);
        int index = ranum.rantask();
        String enunciado = frases.get_enunciado(index);
        String palabra = frases.get_palabra(index);
        String inicio = frases.get_inicio(index);
        String sol = frases.get_sol(index);
        String sol_pt1 = frases.get_sol_pt1(index);
        String sol_pt2 = frases.get_sol_pt2(index);
        String desenlace = frases.get_desenlace(index);

        sotenglish.pts_set = false;

        JLabel enunciado_text = new JLabel(enunciado);
        enunciado_text.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        enunciado_text.setForeground(Color.WHITE);
        enunciado_text.setSize(enunciado_text.getPreferredSize().width, 30); // Le da el tamaño que necesite width
        enunciado_text.setLocation((600 - enunciado_text.getWidth()) / 2, 75);

        JLabel palabra_text = new JLabel(palabra);
        palabra_text.setFont(new Font("Times New Roman", Font.BOLD, 16));
        palabra_text.setForeground(Color.WHITE);
        palabra_text.setSize(palabra_text.getPreferredSize().width, 20);
        palabra_text.setLocation((600 - palabra_text.getWidth()) / 2, 110);

        JLabel sol_spot = new JLabel(inicio + " ____________ " + desenlace);
        sol_spot.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        sol_spot.setForeground(Color.WHITE);
        sol_spot.setSize(sol_spot.getPreferredSize().width, 20);
        sol_spot.setLocation((600 - sol_spot.getWidth()) / 2, 140);

        JTextField sol_input = new JTextField();
        sol_input.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        sol_input.setSize(300, 20);
        sol_input.setLocation((600 - sol_input.getWidth()) / 2, 175);

        JButton confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        confirmar.setForeground(Color.WHITE);
        confirmar.setSize(confirmar.getPreferredSize());
        confirmar.setLocation((600 - confirmar.getWidth()) / 2, 220);
        confirmar.setBackground(new Color(130, 0, 0)); // If she could forget everything, and begin afresh. (Sinner 9)
        confirmar.setFocusPainted(false); // Quita el borde de enfoque parpadeante
        confirmar.setContentAreaFilled(false);  // Permite que el fondo personalizado domine
        confirmar.setOpaque(true);
        confirmar.addActionListener(e -> frases.corregir(sol, sol_input.getText(), sol_pt1, sol_pt2, inicio, desenlace, enunciado));

        ventana.add(enunciado_text);
        ventana.add(palabra_text);
        ventana.add(sol_spot);
        ventana.add(sol_input);
        ventana.add(confirmar);
    }
}
