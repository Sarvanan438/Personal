package DesignPatterns.behavioral.media.state;

public class MediaStateFactory {

    public static MediaState createMediaState(MediaPlayerContext context,MediaStateType type){
        switch (type){
            case PLAY :
                return new PlayMediaState();
            case STOP:
                return new StopMediaState();
            case PAUSE:
                return new PauseMediaState();
            case FAST_FORWARD,REWIND:
                return new FastForwardMediaState();
            case null, default:
                throw new IllegalArgumentException();
        }
    }
}
