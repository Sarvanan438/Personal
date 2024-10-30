package DesignPatterns.behavioral.media.state;

public interface MediaControl {
    void play();
    void fastForward();
    void rewind();
    void seekTo(int timeInSeconds);
    void stop();
    void pause();
}
