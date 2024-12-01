package social.media.platform.config;

public class StubConfiguration{
    private static final String password;

    static {
        System.out.println("Pretend to read configuration");
        password = "12345";
    }


   /* @Override
    public String getPassword() {
        return password;
    }*/
}
