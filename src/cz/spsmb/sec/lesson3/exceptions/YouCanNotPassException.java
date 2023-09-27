package cz.spsmb.sec.lesson3.exceptions;

public class YouCanNotPassException extends RuntimeException {

    public YouCanNotPassException(String message) {
        super(message);
    }
}
