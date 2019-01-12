package calendar;

public class Schedule {
    String date;
    String contents;

    public Schedule(String date, String contents) {
        this.date = date;
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }
}
