package calendar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class Date {
    static Map<String, Integer> map = new HashMap();
    static {
        map.put("일", 1);
        map.put("월", 2);
        map.put("화", 3);
        map.put("수", 4);
        map.put("목", 5);
        map.put("금", 6);
        map.put("토", 7);
    }

    int day1 = 0;
    public void setDay1(String day1) {
        this.day1 = map.get(day1);
    }

    public void print(int endDay) {
        int pos = day1;
        StringBuilder stb = new StringBuilder();
        for(int space = 0; space < pos; ++space) {
            stb.append("  ");
        }
        for(int day = 1; day <= endDay; ++day) {
            stb.append(String.format("%3d", day));

            if(pos % 7 == 0) {
                stb.append("\n");
            }
            pos += 1;
        }
        System.out.println(stb);
    }

}
