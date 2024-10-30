package DesignPatterns.behavioral.media.state;

public interface MediaPlayerSetting {
    void setFastForwardTimePerClick(int timeInSeconds);
    int getFastForwardTimePerClick();
    int getRewindTimePerClick();
}
