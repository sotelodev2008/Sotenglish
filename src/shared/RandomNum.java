package src.shared;

import java.util.Random;

public class RandomNum {
    private int ranum; // Numero random
    Random ragen = new Random();
    public RandomNum(int total){
        this.ranum = total;
    }
    public int rantask() {
        if (ranum == 0) {return ranum;}
        int index = ragen.nextInt(ranum); // si ranum fuera 10 generaria un numero del 0 al 9
        return index;
    }
}
