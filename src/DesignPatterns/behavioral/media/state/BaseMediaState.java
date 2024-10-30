package DesignPatterns.behavioral.media.state;

public abstract class BaseMediaState implements MediaState
{
    private MediaStateChanger mediaStateChanger;
    private MediaPlayer mediaPlayer;
    protected MediaPlayState mediaPlayState;
    BaseMediaState(){
        this.setMediaPlayer( new NullableMediaPlayer());

    }

    protected void changeState(MediaStateType type){
        this.mediaStateChanger.changeState(type);
    }

    public MediaPlayer getMediaPlayer(){
        return this.mediaPlayer;
    }

    @Override
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.mediaStateChanger =  new SimpleMediaStateChanger(this.mediaPlayer);
    }
}
