package social.media.platform.MediaInfo;

public class VideoInfo {
    private String url;
    private int width;
    private int height;
    private int duration;

    public VideoInfo(String url, int width, int height, int duration) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}