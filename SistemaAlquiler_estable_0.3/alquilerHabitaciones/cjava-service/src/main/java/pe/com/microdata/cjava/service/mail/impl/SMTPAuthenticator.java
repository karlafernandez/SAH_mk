package pe.com.microdata.cjava.service.mail.impl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

    private String username;
    private String password;

    public SMTPAuthenticator(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}