package calendar;

import java.util.Scanner;

public class Prompt {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Calendar calendar = new Calendar();
        while(true) {
            System.out.println("연도를 입력하세요.");
            int year = sc.nextInt();

            System.out.println("달을 입력하세요.");
            int month = sc.nextInt();

            System.out.println("1일은 무슨 요일인가요?");
            String day1 = sc.next();
            calendar.setDay1(day1);

            if (year < 0 || month < 1 || month > 12) {
                System.out.println();
                break;
            }

            MaxDayFinder maxDayFinder = new MaxDayFinder();
            int maxDay = maxDayFinder.getMaxDay(year, month);
            calendar.print(maxDay);

        }

    }
}
