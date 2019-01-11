package calendar;

import java.util.*;

public class Scheduler {
    Map<String, List> scheduleMap = new HashMap<String, List>();
    Scanner sc;
    ScheduleDAO scheduleDAO;
    String DATABASE = "jdbc:sqlite:calendar.db";
    public Scheduler() {
        sc = new Scanner(System.in);
        this.scheduleDAO = new ScheduleDAO(DATABASE);
    }

    public void search() {
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

    public void add() {
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
