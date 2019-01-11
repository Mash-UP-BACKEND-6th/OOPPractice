package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        Game();
    }

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

    static int[] User(){
        int user[] = new int[3];

        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 3개 입력(space로 구분)");
        String str = scanner.nextLine();
        System.out.println(str);
        String[] num = str.split(" ");
        for (int i = 0; i < num.length; i++){
            user[i] = Integer.parseInt(num[i]);
        }

        return user;
    }

    static void Game() {
        int strike = 0;
        int ball = 0;
        int count = 0;
        boolean clear = true;

        int user[] = new int[3];

        int com[] = Random();
        for(int k = 0; k < 3; k++){
            System.out.println(com[k]);
        }

        while(clear){
            user = User();
            for(int k = 0; k < 3; k++){
                System.out.println(user[k]);
            }
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
