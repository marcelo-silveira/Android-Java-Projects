package marcelo.junior.exercicio_manha.ui;

import java.util.Random;

public class dado {

    public dado() {
    }

    public int getDado20() {
        return dado20;
    }

    public void setDado20(int dado20) {
        this.dado20 = dado20;
    }

    public  int gerarDado20(){
        Random rand = new Random();
        return  rand.nextInt(20);
    }

    @Override
    public String toString() {
        return "dado{" +
                "dado20=" + dado20 +
                '}';
    }
}
