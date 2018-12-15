import java.io.*;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class DayOfTheWeek {
    private DayOfTheWeek() {
        //Singleton
    }
    /*
        사전에 하나의 String 만들어야 하는가? -> 강의에서는 그런식으로 함
        다음 처럼 생성해야 하는가?
     */
    private static String[] dayOfTheWeek = {"일", "월", "화", "수", "목", "금", "토"};
    public static void print() {
        StringBuilder stb = new StringBuilder();
        stb.append(" ");
        for(String day : dayOfTheWeek) {
            stb.append(String.format(" %s", day));
        }
        System.out.println(stb);
    }
}
