package social.media.platform.exeptions;

public class EmoticonNotFoundExeption extends RuntimeException{
    public EmoticonNotFoundExeption(String messege){
        super(messege);
    }
}
