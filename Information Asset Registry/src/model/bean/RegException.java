package model.bean;

@SuppressWarnings("serial")
public class RegException extends Exception {
    public RegException() {
        super();
    }
    
    public RegException(String message) {
        super(message);
    }

}
