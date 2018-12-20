package calendar;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class Date {
    private Date() {
        //Singleton
    }
    public static void print(int endDay) {
        StringBuilder stb = new StringBuilder();
        for(int day = 1; day <= endDay; ++day) {
            stb.append(String.format("%3d", day));

            if(day % 7 == 0) {
                stb.append("\n");
            }
        }
        System.out.println(stb);
    }
}
