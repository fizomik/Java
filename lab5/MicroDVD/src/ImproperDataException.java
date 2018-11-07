public class ImproperDataException extends Exception {



    public ImproperDataException() {}

    public ImproperDataException(String message) {
        super(message);
    }


    public ImproperDataException(Throwable cause) {
        super(cause);
    }


    public ImproperDataException(String message, Throwable cause) {
        super(message, cause);
    }
}