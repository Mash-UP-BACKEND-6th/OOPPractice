package calendar;

import java.util.*;

public class Prompt {
    Liner liner = new Liner();
    Scanner sc = new Scanner(System.in);
    Calendar calendar = new Calendar();
    Map<String, List> scheduleMap = new HashMap<String, List>();

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
                    addSchedule(); break;
                case 2:
                    searchSchedule(); break;
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

    private void searchSchedule() {
        System.out.println("날짜를 입력하세요 ex) 2018-12-22");
        String day = sc.nextLine();
        if(scheduleMap.containsKey(day)) {
            List<String> list = scheduleMap.get(day);
            for(String schedule : list) {
                System.out.println(schedule);
            }
        } else {
            System.out.println("그날의 스케줄이 없습니다.");
        }
    }

    private void addSchedule() {
        System.out.println("날짜를 입력하세요 ex) 2018-12-22");
        String day = sc.nextLine();
        System.out.println("일정을 입력하세요 ex) 매시업 정기 모임");
        String schedule = sc.nextLine();
        if(scheduleMap.containsKey(day)) {
            List<String> list = scheduleMap.get(day);
            list.add(schedule);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(schedule);
            scheduleMap.put(day, list);
        }
    }
}
