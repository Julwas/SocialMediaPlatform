package social.media.platform.exeptions;

public class EmoticonNotFoundException extends RuntimeException{
    public EmoticonNotFoundException(String message){
        super(message);
    }
}
