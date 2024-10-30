package DesignPatterns.behavioral.media.state;

public class Media {
    private final int timeInSeconds;
    private final String name,path,ext;

    public Media(int timeInSeconds, String name, String path, String ext) {
        this.timeInSeconds = timeInSeconds;
        this.name = name;
        this.path = path;
        this.ext = ext;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getExt() {
        return ext;
    }
}
