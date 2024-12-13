package social.media.platform.config;

import social.media.platform.exceptions.FatalException;
import social.media.platform.interfaces.Configuration;

import java.io.*;


public class TextFileConfiguration implements Configuration {
    private static String password = null;
    private static int maxPosts;
    private static final String filePath = "src\\main\\java\\social\\media\\platform\\configuration.txt";

    static {
        readConfiguration();

    }

    public static void readConfiguration() {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            password = br.readLine();
            if (password != null) {
                System.out.println(" Password :" + password);
            }
            if (password == null || password.isBlank()) {
                throw new FatalException("Critical error!File is empty or does not contain a password. Program termination ");
            }
            String maxPostsLine = br.readLine();
            if (maxPostsLine == null || maxPostsLine.isBlank()) {
                throw new FatalException("Critical error! Missing maxPosts in the configuration file. Program termination.");
            }
            try {
                maxPosts = Integer.parseInt(maxPostsLine);
            } catch (NumberFormatException e) {
                throw new FatalException("Critical error! maxPosts is not a valid number. Program termination.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getMaxPosts() {
        return maxPosts;
    }
}
