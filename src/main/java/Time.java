import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Time {
    TimeChange clock;
    DateTimeFormatter dtf;
    public Time(TimeChange clock) {
       this.clock = clock;
       DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
       dtfb.appendPattern("HH:mm:ss");
       dtf = dtfb.toFormatter();
    }

    public void sendTime() {
        while(true) {
            try {
            clock.changeTime(dtf.format(LocalTime.now()));
            Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace(); }
        }

    }
}
