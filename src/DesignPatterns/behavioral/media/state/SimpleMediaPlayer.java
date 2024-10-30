package DesignPatterns.behavioral.media.state;

/**
 * This class acts a media player responsible for playing media including fast forward etc
 * MediaPlayerSettings This tracks the setting information of media player
 * Media class would be a pojo having information about the media
 * MediaState would track the state the media is in i.e time of media, playing , paused or stopped
 * So the behaviours a media player can do is
 * Select media : not responsibility of media player
 * play media
 * pause media
 * stop media
 * fast forward media
 * rewind media
 *
 * So assuming the finite states a media can be in is
 * Playing , stopped ,paused ,fast forwarding,rewind
 */
public class SimpleMediaPlayer implements MediaPlayer,MediaPlayerContext {
    private MediaPlayerSetting mediaPlayerSetting;
    private Media media;
    private MediaState mediaState;
    SimpleMediaPlayer(){
        this.mediaState = MediaStateFactory.createMediaState(this,MediaStateType.STOP);
        this.mediaState.setMediaPlayer(this);
    }
    @Override
    public void setMedia(Media media) {
        this.media=media;
    }

    @Override
    public void play() {
        this.mediaState.play();
    }

    @Override
    public void fastForward() {
        this.mediaState.fastForward();
    }

    @Override
    public void rewind() {
        this.mediaState.rewind();
    }

    @Override
    public void seekTo(int timeInSeconds) {
        this.mediaState.seekTo(timeInSeconds);
    }

    @Override
    public void stop() {
        this.mediaState.stop();
    }

    @Override
    public void pause() {
        this.mediaState.pause();
    }

    @Override
    public void changeState(MediaState state) {
        this.mediaState=state;
    }

    @Override
    public Media getMedia() {
        return this.media;
    }

    @Override
    public MediaPlayerSetting getMediaSettings() {
        return this.mediaPlayerSetting;
    }
}
