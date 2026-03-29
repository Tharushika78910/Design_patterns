public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(15);
        date.setMonth(4);
        date.setYear(2025);

        System.out.println("Original date: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        date.advanceDays(10);

        System.out.println("Date after advancing 10 days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        date.advanceDays(30);

        System.out.println("Date after advancing 30 more days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());
    }
}