package DesignPatterns.behavioral.media.state;

public class PauseMediaState extends BaseMediaState {
    @Override
    public void play() {
        this.changeState(MediaStateType.PLAY);
        this.getMediaPlayer().play();
    }

    @Override
    public void fastForward() {
        this.changeState(MediaStateType.FAST_FORWARD);
        this.getMediaPlayer().fastForward();
    }

    @Override
    public void rewind() {
        this.changeState(MediaStateType.FAST_FORWARD);
        this.getMediaPlayer().rewind();
    }

    @Override
    public void seekTo(int timeInSeconds) {
        this.changeState(MediaStateType.FAST_FORWARD);
        this.getMediaPlayer().seekTo(timeInSeconds);
    }

    @Override
    public void stop() {
        this.changeState(MediaStateType.STOP);
        this.getMediaPlayer().stop();
    }

    @Override
    public void pause() {

    }
}
