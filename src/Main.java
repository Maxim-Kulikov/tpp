public class Main {
    public static void main(String[] args) {
        Time time1 = null;
        Time time2 = null;
        try {
            time1 = new Time(9552);
            time2 = new Time(0, 72, 3656);

            System.out.println(time1);
            System.out.println(time2);
            System.out.println(time1.compareTo(time2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}