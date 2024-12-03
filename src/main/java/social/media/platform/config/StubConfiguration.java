package social.media.platform.config;

import social.media.platform.actions.FriendRequest;

import java.io.*;
import java.util.logging.Logger;


public class StubConfiguration implements Configuration{
    private static final String password;
    private static final Logger logger = Logger.getLogger(StubConfiguration.class.getName());

    static {
        System.out.println("Read configuration:" );
        readerConfiguration();
        password = "12345";
    }

    public static void readerConfiguration(){
        try (BufferedReader br = new BufferedReader(
                new FileReader("src\\main\\java\\social\\media\\platform\\configuration.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String readerPassword() {
        return password;
    }
}
