package pacman.utils;

public class FrameRate {
    private long lastTime;
    private long delta;
    private int frameCount;

    public void initialize() {
        lastTime = System.currentTimeMillis();
    }

    public void calculate() {
        long current = System.currentTimeMillis();
        delta += current - lastTime;
        lastTime = current;
        frameCount++;
        if (delta > 1000) {
            delta -= 1000;
            frameCount = 0;
        }
    }

    public int getFrameCount() {
        return frameCount;
    }

}
