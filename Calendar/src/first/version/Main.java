package first.version;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static int getSpace(String printDate){
        // 첫번째로 출력될 날짜의 요일을 구하고 (ex. 수 )
        // 해당 요일의 인덱스 반환 (ex. 3 )

        int index = 0;
        Date firstDay; // 달력에 첫번째로 출력되는 날짜
        String weekDay = "일월화수목금토일";

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        DateFormat wf = new SimpleDateFormat("E");

        if(printDate.length()==4){
            try { // parse에 대한 예외처리
                firstDay = df.parse(printDate+"0101");
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else if(printDate.length()==6){
            try {
                firstDay = df.parse(printDate+"01");
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if(printDate.length() == 8){
            try {
                firstDay = df.parse(printDate);
                index = weekDay.indexOf(wf.format(firstDay));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("잘못된 입력!");
        }

        return index;
    }

    public static void main(String[] args) {
        /// 1. 년도 입력시 해당 년도 모든 달 출력
        /// 2. 년도와 월 입력시 해당하는 한달치의 달력 출력
        /// 3. 현재 날짜부터 그해 말까지의 달력 출력
        int type;
        int space;
        String printDate; // 사용자가 출력하고자 하는 날짜

        Scanner scanner = new Scanner(System.in);
        System.out.print("달력 유형 번호를 입력하세요 : ");
        type = scanner.nextInt();

        switch(type){
            case 1:
                System.out.print("출력하고자 하는 달력의 년도를 입력하세요 : ");
                printDate = scanner.next();
                space = getSpace(printDate);
                Caldar_one c1 = new Caldar_one(printDate, space);
                c1.makeCal();
                c1.printCal();
                break;
            case 2:
                System.out.print("출력하고자 하는 달력의 년도와 월을 입력하세요 : ");
                printDate = scanner.next();
                space = getSpace(printDate);
                Caldar_two c2 = new Caldar_two(printDate, space);
                c2.makeCal();
                c2.printCal();
                break;
            case 3:
                System.out.println("오늘 날짜부터 달력을 출력합니다.");
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                printDate = df.format(new Date());
                space = getSpace(printDate);
                Caldar_three c3 = new Caldar_three(printDate, space);
                c3.makeCal();
                c3.printCal();
                break;
        }
    }
}
