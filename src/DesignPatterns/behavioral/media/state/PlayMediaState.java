package DesignPatterns.behavioral.media.state;

public class PlayMediaState extends BaseMediaState{




    @Override
    public void play() {
        // periodically increase the time;
        int currentTime = this.mediaPlayState.getCurrentTimeInSeconds();
        // chaining is not good as it leads to abstraction leak
        if(currentTime<this.getMediaPlayer().getMedia().getTimeInSeconds())
        {
            this.mediaPlayState.setCurrentTimeInSeconds(currentTime+1);
        }else{
            this.stop();
        }

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
        this.changeState(MediaStateType.PAUSE);
        this.getMediaPlayer().pause();
    }


}
