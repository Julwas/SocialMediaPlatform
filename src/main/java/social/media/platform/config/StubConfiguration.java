package social.media.platform.config;

import java.io.*;
import java.util.logging.Logger;


public class StubConfiguration implements Configuration {
    private static final String password = null;
    private static final Logger logger = Logger.getLogger(StubConfiguration.class.getName());

    static {
        readerConfiguration();
       // password;
    }

    public static void readerConfiguration() {

        String filePath = "src\\main\\java\\social\\media\\platform\\configuration.txt";

        String pas = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            pas = br.readLine();
            if (pas != null) {
               // logger.info
                       System.out.println (" Password :" + pas);
            } else {
                logger.info(" File is empty or does not contain a password");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public  String readerPassword() {
      //readerConfiguration();

        return password ;
    }
}
