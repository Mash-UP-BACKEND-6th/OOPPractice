package first.version;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Calendar {
    ArrayList<String> cal = new ArrayList<>();
    int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String year;
    int space;

    public static int getSpace(String printDate) {
        // 첫번째로 출력될 날짜의 요일을 구하고 (ex. 수 )
        // 해당 요일의 인덱스 반환 (ex. 3 )

        int index = 0;
        Date firstDay; // 달력에 첫번째로 출력되는 날짜
        String weekDay = "일월화수목금토일";

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        DateFormat wf = new SimpleDateFormat("E");

        if (printDate.length() == 4) {
            try { // parse에 대한 예외처리
                firstDay = df.parse(printDate + "0101");
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else if (printDate.length() == 6) {
            try {
                firstDay = df.parse(printDate + "01");
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (printDate.length() == 8) {
            try {
                firstDay = df.parse(printDate);
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("잘못된 입력!");
        }

        return index;
    }


}
