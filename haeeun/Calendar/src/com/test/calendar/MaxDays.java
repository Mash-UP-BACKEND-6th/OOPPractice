package com.test.calendar;

import java.util.Scanner;

public class MaxDays {
    private final int MAX_DAYS [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysofMonth(int month){
        return MAX_DAYS[month - 1];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String PROMPT = "cal>";
        MaxDays max = new MaxDays();
        //System.out.println("월을 입력하세요.");
        //int month = scanner.nextInt();
        int month;
        /*while(month != -1){
            System.out.println(month + "월은 " + max.getMaxDaysofMonth(month) + "일까지 있습니다.");
            System.out.println("월을 입력하세요.");
            month = scanner.nextInt();
        }*/
        while(true){
            System.out.println("월을 입력하세요.");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if(month == -1) {
                System.out.println("Have a nice day!");
                break;
            }
            else if(month > 12){
                System.out.println("존재하지 않는 월입니다.");
                //continue;
            }
            else {
                System.out.println(month + "월은 " + max.getMaxDaysofMonth(month) + "일까지 있습니다.");
            }
        }
        scanner.close();
    }
}