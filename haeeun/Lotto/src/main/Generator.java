package main;

import java.util.Random;

public class Generator {

    public int[] Random() {
        int random[] = new int[6];
        for (int i = 0; i < random.length; i++){
//            java.util.Random r = new Random();
            random[i] = (int)(Math.random() * 45) + 1;
            //중복제거
            for (int j = 0; j < i; j++){
                if(random[i] == random[j]){
                    i--;
                }
            }
        }
        return random;
    }

    static int bonus() {
        int bonus = (int)(Math.random() * 45) +1;
        return bonus;
    }

}
