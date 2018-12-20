package maxday;

import java.util.*;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class MaxDayFinder {
    //년도는 사용하지 않으므로 일단 2월은 28일로 사용
    public static int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int getMaxDay(int month) {
        return maxDays[month-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("달을 입력하세요.");

        int month = sc.nextInt();
        int maxDay = MaxDayFinder.getMaxDay(month);
        System.out.println(String.format("%d월은 %d일 까지 있습니다.", month, maxDay));
    }
}
