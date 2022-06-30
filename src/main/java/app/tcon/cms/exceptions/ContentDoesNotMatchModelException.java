package app.tcon.cms.exceptions;

public class ContentDoesNotMatchModelException extends RuntimeException{

    public ContentDoesNotMatchModelException(String message){
        super(message);
    }
}
