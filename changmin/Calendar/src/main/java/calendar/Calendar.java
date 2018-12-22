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

    public Calendar() {
        date = new Date();
        dayOfTheWeek = new DayOfTheWeek();
        liner = new Liner();
    }

    public void print(int days) {
        dayOfTheWeek.print();
        liner.print(WIDTH);
        date.print(days);
    }

    public void setDay1(String day1) {
        date.setDay1(day1);
    }
}
