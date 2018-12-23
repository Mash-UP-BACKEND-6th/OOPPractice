package calendar;

/**
 * Created by changmin on 2018. 12. 15..
 *
 */
public class Calendar {
    private static final int WIDTH = 22;
    private Date date;
    private DayOfTheWeek dayOfTheWeek;
    private Liner liner;
    private MaxDayFinder maxDayFinder;

    public Calendar() {
        date = new Date();
        dayOfTheWeek = new DayOfTheWeek();
        liner = new Liner();
        maxDayFinder = new MaxDayFinder();
    }

    public void print(int year, int month) {
        dayOfTheWeek.print();
        liner.print(WIDTH);
        date.setDay1(getFirstDay(year, month));
        int maxDay = maxDayFinder.getMaxDay(year, month);
        date.print(maxDay);
    }

    public int getFirstDay(int year, int month) {

        /**
         * 2018년은 2017번 + 번(윤년)밀림
         */
        // 1년 1월 1일은 월요일
        int day00010101 = 1;
        int day0101 = getFirstDayThisYear(year);
        for(int i = 1; i < month; ++i) {
            day0101 += maxDayFinder.getMaxDay(year, i);
        }

        return day0101 % 7 + day00010101;
    }

    public int getFirstDayThisYear(int year) {
        int count = 0;
        for(int i = 1; i <=  year; ++i) {
            if(MaxDayFinder.isLeap(i)) {
                count += 1;
            }
        }
        int start = (year + count) % 7 - 1;
        return start;
    }
}
