package social.media.platform.exceptions;

public class LimitPostsException extends RuntimeException{
    public LimitPostsException(String message){
        super(message);
    }
}
