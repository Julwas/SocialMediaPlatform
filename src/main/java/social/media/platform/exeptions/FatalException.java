package social.media.platform.exeptions;

public class FatalException extends RuntimeException{
    public FatalException(String messege){
        super(messege);
    }
}
