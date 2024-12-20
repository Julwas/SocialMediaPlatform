package social.media.platform.Threads;



class ConnectionImage implements ConnectionViewable{
    private String url;

    public ConnectionImage(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public void open() {

            System.out.println("Opened the picture: " + getUrl());
    }
}

