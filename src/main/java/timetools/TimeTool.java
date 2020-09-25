package timetools;

public abstract class TimeTool {
    protected boolean stopped = false;

    public void stop() {
        stopped = true;
    }

    public abstract void start();

}
