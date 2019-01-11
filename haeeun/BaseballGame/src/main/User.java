package main;

import java.util.Scanner;

public class User {

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
}
