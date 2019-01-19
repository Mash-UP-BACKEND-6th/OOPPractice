package main;

import java.util.Scanner;

public class User {

    public int[] User() {
        Scanner scanner = new Scanner(System.in);
        int user[] = new int[6];

        System.out.println("숫자 6개를 입력하세요.(space로 구분)");
        String str = scanner.nextLine();
        String[] num = str.split(" ");
        for(int i = 0; i < num.length -1; i++){
            user[i] = Integer.parseInt(num[i]);
        }

        return user;

    }

    public int Bonus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 숫자 1개를 입력하세요.");
        int bonus = scanner.nextInt();
        return bonus;
    }

}
