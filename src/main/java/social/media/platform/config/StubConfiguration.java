package social.media.platform.config;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;



public class StubConfiguration implements Configuration
{
    private static final String password;

    static {
        System.out.println("Read configuration:" );
        readerConfiguration();
        password = "12345";
    }
    public static String readerConfiguration(){
        try{
            File text = new File("src\\main\\java\\social\\media\\platform\\configuration.txt");
            FileInputStream file = new FileInputStream(text);
        }catch (IOException e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public String readerPassword() {
        return password;
    }
}
