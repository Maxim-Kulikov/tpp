import java.util.Optional;

public class Time implements Comparable<Time> {
    private Integer seconds;
    private Integer minutes;
    private Integer hours;

    private static final String ERROR = "Отрицательное число";

    public Time(Integer seconds) throws RuntimeException {
        secondsToTime(seconds);
    }

    public Time(Integer hours, Integer minutes, Integer seconds) throws RuntimeException {
        secondsToTime(toSeconds(hours, minutes, seconds));
    }

    public int toSeconds(Integer hours, Integer minutes, Integer seconds) throws RuntimeException {
        return getValue(hours) * 3600 + getValue(minutes) * 60 + getValue(seconds);
    }

    private Integer getValue(Integer x) throws RuntimeException {
        x = x == null ? 0 : x;
        if (x < 0) {
            throw new RuntimeException(ERROR);
        }
        return x;
    }

    private void secondsToTime(Integer seconds) throws RuntimeException {
        seconds = getValue(seconds);
        hours = seconds / 3600;
        minutes = (seconds % 3600) / 60;
        this.seconds = seconds - ((hours * 3600) + (minutes * 60));
    }

    @Override
    public String toString() {
        return "Time{" +
                "seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                '}';
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(toSeconds(hours, minutes, seconds),
                toSeconds(o.hours, o.minutes, o.seconds));
    }
}
