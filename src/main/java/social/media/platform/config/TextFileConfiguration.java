package social.media.platform.config;

import social.media.platform.exeptions.FatalException;
import social.media.platform.interfaces.Configuration;

import java.io.*;
import java.util.logging.Logger;


public class TextFileConfiguration implements Configuration {
    private static String password = null;
    private static final Logger logger = Logger.getLogger(TextFileConfiguration.class.getName());
    private static final String filePath = "src\\main\\java\\social\\media\\platform\\configuration.txt";

    static {
        readConfiguration();

    }

    public static void readConfiguration() {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            password = br.readLine();
            if (password != null) {
                System.out.println(" Password :" + password);
            } else {
                throw new FatalException("Critical error! ");
            }
        } catch (FatalException e) {
            System.err.println("Critical error! File is empty or does not contain a password. Program termination");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String givePassword() {
        return password;
    }
}
