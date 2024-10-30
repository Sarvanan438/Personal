package DesignPatterns.behavioral.media.state;

public class SimpleMediaSettings implements MediaPlayerSetting {
    private int forwardTimeInSeconds;

    public SimpleMediaSettings(int forwardTimeInSeconds) {
        this.forwardTimeInSeconds = forwardTimeInSeconds;
    }


    @Override
    public void setFastForwardTimePerClick(int timeInSeconds) {
        this.forwardTimeInSeconds = timeInSeconds;
    }

    @Override
    public int getFastForwardTimePerClick() {
        return this.forwardTimeInSeconds;
    }

    @Override
    public int getRewindTimePerClick() {
        return this.forwardTimeInSeconds;
    }
}
