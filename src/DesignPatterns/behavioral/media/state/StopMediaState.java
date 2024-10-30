package DesignPatterns.behavioral.media.state;

public class StopMediaState extends BaseMediaState {


    @Override
    public void play() {
        this.changeState(MediaStateType.PLAY);
        this.getMediaPlayer().play();
    }

    @Override
    public void fastForward() {
        this.changeState(MediaStateType.FAST_FORWARD);
    }

    @Override
    public void rewind() {
        this.changeState(MediaStateType.FAST_FORWARD);
    }

    @Override
    public void seekTo(int timeInSeconds) {
        this.changeState(MediaStateType.FAST_FORWARD);
    }

    @Override
    public void stop() {
            this.mediaPlayState.setCurrentTimeInSeconds(0);
    }

    @Override
    public void pause() {
            this.stop();
    }


}
