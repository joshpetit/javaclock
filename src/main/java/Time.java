import java.time.LocalTime;

public class Time {
    TimeChange clock;
    public Time(TimeChange clock) {
       this.clock = clock;
    }

    public void sendTime() {
        while(true) {
            try {
            String time = LocalTime.now().toString();
            clock.changeTime(time);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
