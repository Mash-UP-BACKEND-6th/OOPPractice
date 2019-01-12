package calendar;

import java.util.*;

public class Prompt {
    Liner liner = new Liner();
    Scanner sc = new Scanner(System.in);
    Calendar calendar = new Calendar();
    Scheduler scheduler = new Scheduler();

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.start();
    }

    public void menu() {
        liner.print(22);
        System.out.println("1. 일정 등록");
        System.out.println("2. 일정 검색");
        System.out.println("3. 달력 보기");
        System.out.println("4. 일정 등록");
        System.out.println("q. 종료");
        liner.print(22);
    }

    public void start() {
        while(true) {
            menu();
            int cmd = Integer.parseInt(sc.nextLine());
            switch (cmd) {
                case 1:
                    scheduler.add(); break;
                case 2:
                    scheduler.search(); break;
                case 3:
                    printCalendar(); break;
                default:
                    break;
            }
        }

    }

    private void printCalendar() {
        System.out.println("연도를 입력하세요.");
        int year = sc.nextInt();

        System.out.println("달을 입력하세요.");
        int month = sc.nextInt();

        if (year < 0 || month < 1 || month > 12) {
            System.out.println("입력이 잘못됨");
            return;
        }

        calendar.print(year, month);
    }


}
