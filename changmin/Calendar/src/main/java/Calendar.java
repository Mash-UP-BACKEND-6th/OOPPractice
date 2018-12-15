/**
 * Created by changmin on 2018. 12. 15..
 *
 */
public class Calendar {
    private Calendar() {
        //Singleton
    }
    public static void print() {
        DayOfTheWeek.print();
        Liner.print(22);
        Date.print(28);
    }
}
