package social.media.platform.media;

public class AudioInfo {
    private String url;
    private int duration;


    public AudioInfo(String url, int duration) {
        this.url = url;
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }
}