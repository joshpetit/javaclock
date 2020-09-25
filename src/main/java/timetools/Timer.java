package timetools;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer extends TimeTool {
    private TimeChange clock;
    private DateTimeFormatter dtf;
    private LocalTime currentTime;
    private LocalTime end = LocalTime.of(0, 0, 0);
    public Timer(TimeChange clock) {
        this.clock = clock;
        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
        dtfb.appendPattern("HH:mm:ss");
        dtf = dtfb.toFormatter();
    }

    public void start(String time) {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        currentTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
        ses.scheduleAtFixedRate(() -> {
            currentTime = currentTime.minusSeconds(1);
            if (currentTime.equals(end) && !stopped) {
                ses.shutdown();
            }
            clock.changeTime(dtf.format(currentTime));
        }, 0, 1, TimeUnit.SECONDS);

    }

    @Override
    public void start() {

    }
}
