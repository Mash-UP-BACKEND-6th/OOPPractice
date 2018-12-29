package first.version;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Caldar_one extends Calendar {
    ArrayList<String> cal = new ArrayList<>();
    int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String year;
    int space;
    /// 1.
    /// 년도("2019") 입력시 해당 년도 모든 달 출력

    // 첫 달은 무조건 1월이니까 maxDay = 31
    // 해당년도의 1월 1일이 무슨 요일인지만 알면됨(특히, index!!)

    Caldar_one(String year) {
        this.year = year;
        this.space = getSpace(year);
    }

    public void makeCal() {

        for (int i = 0; i < space; i++) {
            cal.add("  ");
        }

        for (int maxDay : maxDays) {

            for (int i = 1; i <= maxDay; i++) {
                cal.add(String.valueOf(i));
            }

            for (int i = 0; i < 7; i++) {
                cal.add("  ");
            }

        }

    }

    public void printCal() {
        int isEnter = 6;
        int monthCount = 1;
        System.out.println(year + "년도 " + monthCount + "월");
        System.out.println("일 월 화 수 목 금 토");
        for (int i = 0; i < cal.size(); i++) {
            System.out.printf("%2s", cal.get(i));
            System.out.print(" ");
            if (i == isEnter) {
                System.out.println();
                isEnter += 7;
                if ((cal.get(i)).equals("  ")) {
                    monthCount++;
                    if (monthCount > 12)
                        break;
                    System.out.println();
                    System.out.println(year + "년도 " + monthCount + "월");
                    System.out.println("일 월 화 수 목 금 토");
                }
            }
        }
    }

}
