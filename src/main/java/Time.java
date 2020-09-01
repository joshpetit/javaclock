import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Time {
    TimeChange clock;
    DateTimeFormatter dtf;

    public Time(TimeChange clock) {
        this.clock = clock;
        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
        dtfb.appendPattern("h:mm:ss");
        dtf = dtfb.toFormatter();
        sendTime();
    }

    public void sendTime() {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(() -> {
            clock.changeTime(dtf.format(LocalTime.now()));
        }, 0, 1,TimeUnit.SECONDS);
    }
}
