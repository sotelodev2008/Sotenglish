package src.shared;

import javax.swing.JFrame;
import src.pc.sotenglish;
import src.pc.window.results;

public class data {
    private static String[] enunciado = null;
    private static String[] palabra = null;
    private static String[] inicio = null;
    private static String[] sol = null;
    private static String[] sol_pt1 = null;
    private static String[] sol_pt2 = null;
    private static String[] desenlace = null;
    private boolean[] tabien;
    public int total;
    JFrame ventana;

    public data(int level, JFrame ventana) {
        this.ventana = ventana;
        if (level == 1) {B2();} // Frases B2
        else if (level == 2) {C1();} // Frases C1
        else if (level == 3) {C2();} // Frases C2
    }

    void B2() {
        enunciado = new String[]{"Joan finds keeping grammatical rules in mind very difficult.", "I'm sorry I'm late, said Peter."};
        palabra = new String[]{"EASY", "APOLOGISED"};
        inicio = new String[]{"Joan says it", "Peter"};
        sol = new String[]{"is not easy to keep", "apologised for being"};
        sol_pt1 = new String[]{"is not easy", "apologised"};
        sol_pt2 = new String[]{"to keep", "for being"};
        desenlace = new String[]{"grammatical rules in mind.", "late."};
        total = enunciado.length;
    }
    void C1() {
        enunciado = new String[]{"I have never studied so hard in my life for an exam.", "We must take as much advantage as possible of any opportunity to speak English."};
        palabra = new String[]{"HAVE", "MOST"};
        inicio = new String[]{"Never before", "We have"};
        sol = new String[]{"have I studied so hard", "to make the most of"};
        sol_pt1 = new String[]{"have I", "to make"};
        sol_pt2 = new String[]{"studied so hard", "the most of"};
        desenlace = new String[]{"in my life for an exam.", "any opportunity to speak English."};
        total = enunciado.length;
    }
    void C2() {
        enunciado = new String[]{"As soon as the tennis match scan ended, the crowd bursts into cheers.", "I'm sure it was a surprise to everyone when the headteacher resigned suddenly."};
        palabra = new String[]{"SOONER", "BLUE"};
        inicio = new String[]{"No", "The headteacher's sudden resignation must"};
        sol = new String[]{"sooner had the tennis match ended than", "have come out of the blue to"};
        sol_pt1 = new String[]{"sooner had the tennis match ended", "have come"};
        sol_pt2 = new String[]{"than", "out of the blue to"};
        desenlace = new String[]{"the crowd burst into cheers.", "everyone."};
        total = enunciado.length;
    }

    public String get_enunciado(int index) {
        return enunciado[index];
    }
    public String get_palabra(int index) {
        return palabra[index];
    }
    public String get_inicio(int index) {
        if (inicio[index].equals("")) {return "_";}
        return inicio[index];
    }
    public String get_sol(int index) {
        return sol[index];
    }
    public String get_sol_pt1(int index) {
        return sol_pt1[index];
    }
    public String get_sol_pt2(int index) {
        return sol_pt2[index];
    }
    public String get_desenlace(int index) {
        if (desenlace[index].equals("")) {return "_";}
        return desenlace[index];
    }

    public void corregir(String sol, String user_sol, String sol_pt1, String sol_pt2, String inicio, String desenlace, String enunciado) {
        if (user_sol.contains(sol_pt1) ^ user_sol.contains(sol_pt2)){ // Este operador comprueba si se cumple una de las condiciones, si se cumplen las 2 no se ejecuta
            sotenglish.pts++;
            sotenglish.pts_text.setText("Puntos: " + sotenglish.pts);
            tabien = new boolean[]{true, false};
        }
        else if(!sol.equals(user_sol)){
            sotenglish.pts--;
            sotenglish.pts_text.setText("Puntos: " + sotenglish.pts);
            tabien = new boolean[]{false, false};}
            else{
                sotenglish.pts++;
                sotenglish.pts++;
                sotenglish.pts_text.setText("Puntos: " + sotenglish.pts);
                tabien = new boolean[]{true, true};
            }
        results comprobar = new results(enunciado, inicio, sol, desenlace, ventana);
        comprobar.results_chooser(tabien);
    }
}
