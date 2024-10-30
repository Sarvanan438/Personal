package DesignPatterns.behavioral.media.state;

public class MediaPlayState {

    private int currentTimeInSeconds;

    public MediaPlayState(int currentTimeInSeconds) {
        this.currentTimeInSeconds = currentTimeInSeconds;
    }

    public int getCurrentTimeInSeconds() {
        return currentTimeInSeconds;
    }

    public void setCurrentTimeInSeconds(int currentTimeInSeconds) {
        this.currentTimeInSeconds = currentTimeInSeconds;
    }
}
