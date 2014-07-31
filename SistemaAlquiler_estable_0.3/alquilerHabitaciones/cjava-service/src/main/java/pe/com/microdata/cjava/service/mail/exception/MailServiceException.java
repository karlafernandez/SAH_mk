package pe.com.microdata.cjava.service.mail.exception;

public class MailServiceException extends Exception{

    public MailServiceException() {
    }

    public MailServiceException(String msg) {
        super(msg);
    }

    public MailServiceException(Exception e) {
        super(e);
    }
}