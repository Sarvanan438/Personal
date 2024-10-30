package DesignPatterns.behavioral.media.state;

public class SimpleMediaStateChanger implements MediaStateChanger{
    private MediaPlayer mediaPlayer;

    public SimpleMediaStateChanger(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void changeState(MediaStateType type) {
        MediaState state = MediaStateFactory.createMediaState(mediaPlayer,type);
        state.setMediaPlayer(mediaPlayer);
        mediaPlayer.changeState(state);
    }
}
