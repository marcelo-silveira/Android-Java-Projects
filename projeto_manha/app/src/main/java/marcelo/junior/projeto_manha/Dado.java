package marcelo.junior.projeto_manha;

import java.util.Random;

public class Dado {
    public Dado() {
    }

    public int gerarDado20(){
        Random rand = new Random();
        return  rand.nextInt(20);
    }

    public int gerarDado12(){
        Random rand = new Random();
        return  rand.nextInt(12);
    }
    public int gerarDado6(){
        Random rand = new Random();
        return  rand.nextInt(6);
    }

    @Override
    public String toString() {
        return   "" +
                "D20 = " + gerarDado20()+
                "\nD12 = "+ gerarDado12()+
                "\nD6 = "+ gerarDado6();
    }
}
