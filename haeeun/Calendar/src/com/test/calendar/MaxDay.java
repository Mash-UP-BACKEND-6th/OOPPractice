package com.test.calendar;

import java.util.Scanner;

public class MaxDay {
    public static void main(String[] args){
        int [] day = new int [] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("달을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String month;
        month = scanner.next();
        int m = Integer.parseInt(month);
        System.out.println(m + "월은 " + day[m-1] + "일까지 있습니다.");
    }
}
