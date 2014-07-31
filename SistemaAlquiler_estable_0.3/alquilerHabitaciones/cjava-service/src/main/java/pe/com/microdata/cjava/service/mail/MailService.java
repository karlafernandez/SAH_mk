/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.mail;

import java.io.InputStream;
import pe.com.microdata.cjava.service.mail.exception.MailServiceException;
 

/**
 *
 * @author Alejandra Gonzales
 */
 public interface MailService {

    public abstract void send(String senderAddress, String toAddress, String cc, String bcc, String subject, String msgTxt)
            throws MailServiceException;

    public abstract void send(String senderAddress, String[] to, String[] cc, String[] bcc, String subject, String msgTxt)
            throws MailServiceException;

    public abstract void sendAsHtml(String senderAddress, String toAddress, String cc, String bcc, String subject, String msgHtml)
            throws MailServiceException;

    public abstract void sendAsHtml(String senderAddress, String[] to, String[] cc, String[] bcc, String subject, String msgHtml)
            throws MailServiceException;

    public abstract void sendAttachment(String senderAddress, String[] toAddress, String cc, String bcc, String subject, String msgHtml, InputStream is, String content, String fileName)
            throws MailServiceException;
}
