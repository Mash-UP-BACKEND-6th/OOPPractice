import java.util.ArrayList;

public class Caldar_three extends Calendar{
    ArrayList<String> cal = new ArrayList<>();
    String year;
    String month;
    String day;
    int space;

    int monthN;
    int dayN;

    Caldar_three(String printDate) {
        this.year = printDate.substring(0, 4);
        this.month = printDate.substring(4, 6);
        this.day = printDate.substring(6, 8);
        this.space = space;

        monthN = Integer.parseInt(month);
        dayN = Integer.parseInt(day);
    }

    public void makeCal() {

        int[] maxDays2 = new int[12 - (monthN - 1)];
        System.arraycopy(getMaxDays(), monthN - 1, maxDays2, 0, maxDays2.length);

        for (int i = 0; i < space; i++) {
            cal.add("  ");
        }

        for (int maxDay : maxDays2) {

            for (int i = dayN; i <= maxDay; i++) {
                cal.add(String.valueOf(i));
            }

            for (int i = 0; i < 7; i++) {
                cal.add("  ");
            }

        }

    }


    public void printCal() {
        int isEnter = 6;
        int monthCount = monthN;
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
