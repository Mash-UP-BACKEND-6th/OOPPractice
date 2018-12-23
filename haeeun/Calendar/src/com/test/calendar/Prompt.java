package com.test.calendar;

import java.text.ParseException;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Prompt {
    static final String PROMPT = "> ";

    public void printMenu(){
        System.out.println("+------------------+");
        System.out.println("|1. 일정 등록");
        System.out.println("|2. 일정 검색");
        System.out.println("|3. 달력 보기");
        System.out.println("|h. 도움말 q. 종료");
        System.out.println("+------------------+");
        System.out.println("명령 (1, 2, 3, h, q)");
        System.out.print("> ");
    }

    public int putSpace(String str_weekday){
        if(str_weekday.equals("SU")){ return 0; }
        else if(str_weekday.equals("MO")){ return 1; }
        else if(str_weekday.equals("TU")){ return 2; }
        else if(str_weekday.equals("WE")){ return 3; }
        else if(str_weekday.equals("TH")){ return 4; }
        else if(str_weekday.equals("FR")){ return 5; }
        else if(str_weekday.equals("SA")){ return 6; }
        else { return 0; }
    }

    public void runPrompt() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        VirtualCalendar vc = new VirtualCalendar();

        boolean isLoop = true;
        while(isLoop){
            printMenu();
            String cmd = scanner.next();

            switch(cmd){
                case("1"):
                    cmdRegister(scanner, vc);
                    break;
                case("2"):
                    cmdSearch(scanner, vc);
                    break;
                case("3"):
                    viewCalendar(scanner, vc);
                    break;
                case("h"):
                    hint();
                    break;
                case("q"):
                    isLoop = false;
                    break;
            }
        }
        System.out.println("Bye");
        scanner.close();
    }

    private void hint() {
    }

    private void cmdRegister(Scanner scanner, VirtualCalendar vc) throws ParseException {
        //Scanner sc = new Scanner(System.in);
        System.out.println("[일정 등록] 날짜를 입력하세요. (yyyy-MM-dd)");
        System.out.print(PROMPT);
        String date = scanner. next();
        System.out.println("일정을 입력하세요.");
        System.out.print(PROMPT);
        String schedule = scanner.next();

        vc.registerPlan(date, schedule);
    }

    private void cmdSearch(Scanner scanner, VirtualCalendar vc) throws ParseException{
        System.out.println("[일정 검색] 날짜를 입력하세요. (yyyy-MM-dd)");
        System.out.print(PROMPT);
        String date = scanner.next();
        PlanItem schedule;
        schedule = vc.searchSchedule(date);
        if (schedule != null){
            System.out.println(schedule.detail);
        } else {
            System.out.println("There is no schedule.");
        }
    }

    private void viewCalendar(Scanner scanner, VirtualCalendar vc) {
        int year;
        int month;

        System.out.println("년도을 입력하세요.");
        System.out.print("YEAR> ");
        year = scanner.nextInt();

        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        month = scanner.nextInt();

        if(month > 12 || month <1){
            System.out.println("잘못된 입력입니다.");
            return;
        }

        vc.printCalendar(year, month);
    }

    public static void main(String[] args) throws ParseException{

        Prompt p = new Prompt();
        p.runPrompt();

    }
}
