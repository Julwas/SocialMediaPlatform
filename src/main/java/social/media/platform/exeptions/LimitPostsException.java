package social.media.platform.exeptions;

public class LimitPostsException extends RuntimeException{
    public LimitPostsException(String message){
        super(message);
    }
}
