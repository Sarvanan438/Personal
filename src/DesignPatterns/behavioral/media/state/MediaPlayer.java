package DesignPatterns.behavioral.media.state;

public interface MediaPlayer extends MediaControl,MediaPlayerContext{

    void setMedia(Media media);

}
