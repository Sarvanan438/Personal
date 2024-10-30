package DesignPatterns.behavioral.media.state;

public interface MediaPlayerContext {
    void changeState(MediaState state);
    Media getMedia();
    MediaPlayerSetting getMediaSettings();
}
