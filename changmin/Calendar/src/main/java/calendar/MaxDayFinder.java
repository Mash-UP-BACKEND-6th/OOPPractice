package calendar;


/**
 * Created by changmin on 2018. 12. 15..
 */
public class MaxDayFinder {
    //년도는 사용하지 않으므로 일단 2월은 28일로 사용
    public static int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int[] leapYearMaxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeap(int year) {
        return year % 400 == 0 && year % 10 == 0 && year % 4 == 0 || !(year % 4 == 0 && year % 10 == 0) || year % 4 == 0;
    }

    public int getMaxDay(int year, int month) {
        if(isLeap(year)) {
            return leapYearMaxDays[month-1];
        }
        return maxDays[month-1];
    }
}
