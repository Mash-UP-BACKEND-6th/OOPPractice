package com.test.calendar;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        int a, b;
        Scanner scanner = new Scanner(System.in);
        String s1, s2;
        System.out.println("두 수를 입력해주세요");
        s1 = scanner.next();
        s2 = scanner.next();
        System.out.print(s1 + " + " + s2 + " = ");
        a = Integer.parseInt(s1);
        b = Integer.parseInt(s2);
        System.out.println(a+b);
        scanner.close();
    }
}
