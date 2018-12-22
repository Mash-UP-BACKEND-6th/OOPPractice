package com.test.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class VirtualCalendar {

    //1970/Jan/1st/Thursday
    static final int BASE_YEAR = 1970;
    static final int BASE_MONTH = 1;
    static final int BASE_DAY = 0;
    static final int BASE_WEEKDAY = 3;

    private final int MAX_DAYS [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int LEAP_YEAR [] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap <Date, PlanItem> planMap;

    public VirtualCalendar(){
        //HashMap : 키로 값을 검색함 >> Date로 String 검
        planMap = new HashMap<Date, PlanItem>();
    }

    public int getMaxDaysofMonth(int year, int month){
        if(isLeapYear(year)){
            return LEAP_YEAR[month - 1];
        }
        else {
            return MAX_DAYS[month - 1];
        }
    }

    public boolean isLeapYear(int year){
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }

    private int getWeekday(int year, int month, int day) {

        int count = 0;

        for(int j = BASE_YEAR; j < year; j++){
            int delta = isLeapYear(j) ? 366 : 365;
            count += delta;
        }

        for(int j = BASE_MONTH; j < month; j++){
            int delta = getMaxDaysofMonth(year, j);
            count += delta;
        }

        count += day;
        int weekday = (count + BASE_WEEKDAY) % 7;

        return weekday;
    }

    public void registerPlan(String date, String schedule) {
        PlanItem p = new PlanItem(date, schedule);
        planMap.put(p.getPlanDate(), p);
    }

    public PlanItem searchSchedule(String date) {
        Date dt = PlanItem.getDatefromString(date);
        return planMap.get(dt);
    }

    public void printCalendar(int year, int month){
        System.out.printf("       << %d년 %d월 >>\n", year, month);
        System.out.println("  SU  MO  TU  WE  TH  FR  SA");
        System.out.println("-----------------------------");

        int weekday = getWeekday(year, month, 1);

        for(int i = 0; i < weekday; i++){
            System.out.print("    ");
        }

        int max = getMaxDaysofMonth(year, month);
        int count = 7 - weekday;

        //print first line
        for (int i = 1; i < count; i++){
            System.out.printf("%4d", i);
        }

        for (int i = count; i <= max; i++){
            System.out.printf("%4d", i);
            if ( (i-count) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    //simple test code
    public static void main(String[] args) throws ParseException {
        VirtualCalendar vc = new VirtualCalendar();

        vc.registerPlan("2017-06-23", "TEST");
        System.out.println(vc.searchSchedule("2017-06-23").equals("TEST"));
    }
}