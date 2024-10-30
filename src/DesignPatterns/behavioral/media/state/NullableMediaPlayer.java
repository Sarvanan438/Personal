package DesignPatterns.behavioral.media.state;

public class NullableMediaPlayer implements MediaPlayer{
    @Override
    public void changeState(MediaState state) {

    }

    @Override
    public Media getMedia() {
        return new Media(0,"","","");
    }

    @Override
    public MediaPlayerSetting getMediaSettings() {
        return new SimpleMediaSettings(0);
    }

    @Override
    public void setMedia(Media media) {

    }

    @Override
    public void play() {

    }

    @Override
    public void fastForward() {

    }

    @Override
    public void rewind() {

    }

    @Override
    public void seekTo(int timeInSeconds) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void pause() {

    }
}
