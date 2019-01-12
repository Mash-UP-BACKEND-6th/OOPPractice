package main;

import java.util.Arrays;
import java.util.Random;

public class Baseball {

    static int[] Random() {
        int com[] = new int[3];
        for (int i = 0; i < 3; i++){
            Random r = new Random();
            com[i] = r.nextInt(9) + 1;
            //중복제거
            for (int j = 0; j < i; j++){
                if(com[i] == com[j]){
                    i--;
                }
            }
        }
        return com;
    }

    static void Game() {
        int strike = 0;
        int ball = 0;
        int count = 0;
        boolean clear = true;
        User gamer = new User();

        int user[] = new int[3];

        int com[] = Random();

        while(clear){
            user = gamer.User();

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(com[i] == user[j] && (i == j)){
                        strike++;
                    } else if(com[i] == user[j] && (i != j)){
                        ball++;
                    }
                }
            }
            System.out.println(strike + "strike " + ball + "ball");
            count++;
            if(strike == 3){
                clear = false;
            } else {
                strike = 0;
                ball = 0;
                Arrays.fill(user, 0);
            }
        }
        System.out.println("정답은 " + user[0] + user[1] + user[2] + " 입니다.");
        System.out.println("도전 횟수: " + count);
    }
}
