package firstVersion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Prompt {
    boolean isEnd = false;

    Scanner scanner = new Scanner(System.in);

    public boolean initPrompt() {
        String whatToDo;
        System.out.println("+--------------------+");
        System.out.println("| 1. 일정 등록       |");
        System.out.println("| 2. 일정 검색       |");
        System.out.println("| 3. 달력 보기       |");
        System.out.println("| h. 도움말 q. 종료  |");
        System.out.println("+--------------------+");
        System.out.print("WhatToDo > ");
        whatToDo = scanner.next();

        switch (whatToDo) {
            case "1":
                addSchedule();
                break;
            case "2":
                searchSchedule();
                break;
            case "3":
                calPrompt();
                break;
            case "h":
                System.out.println("도움말");
                break;
            case "q":
                System.out.println("종료합니다 :) ");
                isEnd = true;
        }

        return isEnd;
    }

    public void addSchedule() {
        String addDate, addPlan;

        System.out.println("[ 일정 등록 ] 날짜를 입력하세요 (예. 20181224)");
        System.out.print("Date > ");
        addDate = scanner.next();
        System.out.println("[ 일정 등록 ] 일정을 입력하세요");
        System.out.print("Plan > ");
        addPlan = scanner.next();

        Schedule s = new Schedule();
        s.add(addDate, addPlan);
    }

    public void searchSchedule() {
        String searchDate;

        System.out.println("[ 일정 검색 ] 날짜를 입력하세요 (예. 20181224)");
        System.out.print("Date > ");
        searchDate = scanner.next();

        Schedule s = new Schedule();
        s.search(searchDate);
    }

    public void calPrompt() {
        String calendarType;
        System.out.println("+--------------------+");
        System.out.println("| 달력 보기          |");
        System.out.println("| 1. 특정 년도       |");
        System.out.println("| 2. 특정 달         |");
        System.out.println("| 3. 오늘 부터       |");
        System.out.println("| s. 설정  q. 종료   |");
        System.out.println("+--------------------+");
        System.out.print("Calendar Type > ");
        calendarType = scanner.next();

        String printDate;

        switch (calendarType) {
            case "1":
                System.out.print("출력하고자 하는 달력의 년도를 입력하세요 : ");
                printDate = scanner.next();
                Caldar_one c1 = new Caldar_one(printDate);
                c1.makeCal();
                c1.printCal();
                break;
            case "2":
                System.out.print("출력하고자 하는 달력의 년도와 월을 입력하세요 : ");
                printDate = scanner.next();
                Caldar_two c2 = new Caldar_two(printDate);
                c2.makeCal();
                c2.printCal();
                break;
            case "3":
                System.out.println("오늘 날짜부터 달력을 출력합니다.");
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                printDate = df.format(new Date());
                Caldar_three c3 = new Caldar_three(printDate);
                c3.makeCal();
                c3.printCal();
                break;
            case "s":
                System.out.println("도움말");
                break;
            case "q":
                System.out.println("종료합니다 :) ");
                isEnd = true;
        }

    }

    public void setPrompt() {
        System.out.println("+--------------------+");
        System.out.println("| 설정               |");
        System.out.println("| 1. 언어 설정       |");
        System.out.println("| 2. 일정 표시 여부  |");
        System.out.println("| q. 종료            |");
        System.out.println("+--------------------+");
        System.out.print("Setting > ");
    }

}
