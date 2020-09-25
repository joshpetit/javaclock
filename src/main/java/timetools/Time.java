package timetools;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Time extends TimeTool{
    TimeChange clock;
    DateTimeFormatter dtf;

    public Time(TimeChange clock) {
        this.clock = clock;
        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
        dtfb.appendPattern("h:mm:ss");
        dtf = dtfb.toFormatter();
    }

    @Override
    public void start() {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(() -> {
            if (stopped) {
                ses.shutdown();
            }
            clock.changeTime(dtf.format(LocalTime.now()));
        }, 0, 1,TimeUnit.SECONDS);
    }
}
