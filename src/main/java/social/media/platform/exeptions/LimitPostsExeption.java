package social.media.platform.exeptions;

public class LimitPostsExeption extends RuntimeException{
    public LimitPostsExeption(String message){
        super(message);
    }
}
