package DesignPatterns.behavioral.media.state;

public class FastForwardMediaState extends BaseMediaState {
    @Override
    public void play() {
        this.changeState(MediaStateType.PLAY);
        this.getMediaPlayer().play();
    }

    @Override
    public void fastForward() {
        int currentPlayTime = this.mediaPlayState.getCurrentTimeInSeconds();
        int fastForwardedTime = this.getMediaPlayer().getMediaSettings().getFastForwardTimePerClick() + currentPlayTime;
        int mediaEndTime = this.getMediaPlayer().getMedia().getTimeInSeconds();
        this.mediaPlayState.setCurrentTimeInSeconds(Math.min(fastForwardedTime,mediaEndTime));
    }

    @Override
    public void rewind() {
        int currentPlayTime = this.mediaPlayState.getCurrentTimeInSeconds();
        int rewindTime = currentPlayTime-this.getMediaPlayer().getMediaSettings().getRewindTimePerClick();
        this.mediaPlayState.setCurrentTimeInSeconds(Math.max(0,rewindTime));
    }

    @Override
    public void seekTo(int timeInSeconds) {
        this.mediaPlayState.setCurrentTimeInSeconds(timeInSeconds);
    }

    @Override
    public void stop() {
        this.changeState(MediaStateType.STOP);
        this.getMediaPlayer().stop();
    }

    @Override
    public void pause() {
        this.changeState(MediaStateType.PAUSE);
        this.getMediaPlayer().pause();
    }
}
