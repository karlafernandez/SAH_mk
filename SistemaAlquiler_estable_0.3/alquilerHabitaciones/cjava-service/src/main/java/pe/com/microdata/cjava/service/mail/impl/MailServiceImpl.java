/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.mail.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.service.mail.MailService;
import pe.com.microdata.cjava.service.mail.dto.MailParametersDTO;
import pe.com.microdata.cjava.service.mail.exception.MailServiceException;

/**
 *
 * @author Alejandra Gonzales
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

//    @Autowired
//    ParametrosDAO parametrosDAO;
    @Autowired
    @Qualifier("mailBean")
    MailParametersDTO mailParametersDTO;
    /**
     * Create a jetBean within the Spring Application Context
     *
     * @return a bean
     */
    final String username = "";
    final String password = "";

    public @Bean(name = "mailBean")
    MailParametersDTO crearMailBean() {

        MailParametersDTO bean = new MailParametersDTO();
        bean.setHostname("panamera.websitewelcome.com");
        bean.setPort("465");
        bean.setUsername("siga_cjava@cjavaperu.com");
        bean.setPassword("@cjavaperu@");
        bean.setNicksender("siga_cjava@cjavaperu.com");

        return bean;
    }

    public void send(String senderAddress, String toAddress, String cc,
            String bcc, String subject, String msgTxt)
            throws MailServiceException {
        try {
            MimeMessage msg = new MimeMessage(getSession());
            msg.setFrom(new InternetAddress(senderAddress));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            if (cc != null && cc.length() > 0) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            if (bcc != null && bcc.length() > 0) {
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }

            msg.setSubject(subject);
            msg.setText(msgTxt);
            sendMessage(msg);
        } catch (AddressException ex) {
            ex.printStackTrace();
            throw new MailServiceException("Mail Service Exception");
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw new MailServiceException("Mail Service Exception");
        }
    }

    public void send(String senderAddress, String[] to, String[] cc,
            String[] bcc, String subject, String msgTxt)
            throws MailServiceException {
        try {
            MimeMessage msg = new MimeMessage(getSession());
            msg.setFrom(new InternetAddress(senderAddress));
            if (to != null && to.length > 0) {
                for (int i = 0; i < to.length; i++) {
                    msg.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to[i]));
                }
            } else {
                return;
            }

            if (cc != null && cc.length > 0) {
                for (int i = 0; i < cc.length; i++) {
                    msg.addRecipient(Message.RecipientType.CC,
                            new InternetAddress(cc[i]));
                }
            }

            if (bcc != null && bcc.length > 0) {
                for (int i = 0; i < bcc.length; i++) {
                    msg.addRecipient(Message.RecipientType.BCC,
                            new InternetAddress(bcc[i]));
                }
            }

            msg.setSubject(subject);
            msg.setText(msgTxt);
            sendMessage(msg);
        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendAsHtml(String senderAddress, String toAddress, String cc,
            String bcc, String subject, String msgHtml) throws MailServiceException {
        try {
            MimeMessage msg = new MimeMessage(getSession());
            msg.setHeader("From", senderAddress);
            msg.setHeader("Content-Type", "text/html; charset=iso-8859-1");

            msg.setFrom(new InternetAddress(senderAddress));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            if (cc != null && cc.length() > 0) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            if (bcc != null && bcc.length() > 0) {
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }

            msg.setSubject(subject);
            msg.setContent(msgHtml, "text/html; charset=ISO-8859-1");
            sendMessage(msg);
        } catch (AddressException ex) {
            ex.printStackTrace();
            throw new MailServiceException("Mail Service Exception");
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw new MailServiceException("Mail Service Exception");
        }
    }

    public void sendAsHtml(String senderAddress, String[] to, String[] cc,
            String[] bcc, String subject, String msgHtml)
            throws MailServiceException {

        try {
            MimeMessage msg = new MimeMessage(getSession());
            msg.setSentDate(new Date());
            if (to != null && to.length > 0) {
                msg.setHeader("Sender", to[0]);
            }

            msg.setHeader("From", senderAddress);
            msg.setHeader("Content-Type", "text/html; charset=iso-8859-1");

            if (to != null && to.length > 0) {
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to[0]));
            }

            msg.setFrom(new InternetAddress(senderAddress));
            msg.setSubject(subject);
            msg.setText(msgHtml);

            msg.setFrom(new InternetAddress(senderAddress, mailParametersDTO.getNicksender()));
            if (to != null && to.length > 0) {
                for (int i = 0; i < to.length; i++) {
                    msg.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to[i]));
                }
            } else {
                throw new MailServiceException("At last one to adress must be provided for send mail...");
            }

            if (cc != null && cc.length > 0) {
                for (int i = 0; i < cc.length; i++) {
                    msg.addRecipient(Message.RecipientType.CC,
                            new InternetAddress(cc[i]));
                }
            }

            if (bcc != null && bcc.length > 0) {
                for (int i = 0; i < bcc.length; i++) {
                    msg.addRecipient(Message.RecipientType.BCC,
                            new InternetAddress(bcc[i]));
                }
            }
            msg.setSubject(subject);
            msg.setContent(msgHtml, "text/html; charset=ISO-8859-1");
            sendMessage(msg);
        } catch (Exception e) {
            throw new MailServiceException(e);
        }
    }

    public void sendAttachment(String senderAddress, String[] toAddress, String cc,
            String bcc, String subject, String msgHtml, InputStream is, String content, String fileName)
            throws MailServiceException {
        try {
            MimeMessage msg = new MimeMessage(getSession());
            msg.setHeader("From", senderAddress);
            msg.setHeader("Content-Type", "text/html; charset=iso-8859-1");
            msg.setFrom(new InternetAddress(senderAddress));
            if (toAddress != null && toAddress.length > 0) {
                for (int i = 0; i < toAddress.length; i++) {
                    msg.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(toAddress[i]));
                }
            } else {
                throw new MailServiceException("At last one to adress must be provided for send mail...");
            }

            if (cc != null && cc.length() > 0) {
                msg.addRecipient(Message.RecipientType.CC,
                        new InternetAddress(cc));
            }

            if (bcc != null && bcc.length() > 0) {
                msg.addRecipient(Message.RecipientType.BCC,
                        new InternetAddress(bcc));
            }

            msg.setSubject(subject);
            if (is != null) {
                BodyPart bp = new MimeBodyPart();
                bp.setContent(msgHtml, "text/html; charset=ISO-8859-1");
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(bp);
                bp = new MimeBodyPart();
                bp.setFileName(fileName);
                //System.out.println("CONTENT " + content);
                //System.out.println("NAME FILE " + fileName);
                DataSource ds = new ByteArrayDataSource(is, content);
                bp.setDataHandler(new DataHandler(ds));
                mp.addBodyPart(bp);
                msg.setContent(mp);
            } else {
                msg.setContent(msgHtml, "text/html; charset=ISO-8859-1");
            }
            sendMessage(msg);
        } catch (Exception e) {
            throw new MailServiceException(e);
        }
    }

    @SuppressWarnings("static-access")
    public void sendMessage(MimeMessage message) throws MessagingException {
        Transport transp = getSession().getTransport();
        transp.connect();
        transp.send(message);
        transp.close();
    }

    public Session getSession() {
        Properties props = new Properties();
        //props.put("mail.host", hostname);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailParametersDTO.getHostname());
        props.setProperty("mail.port", mailParametersDTO.getPort());
        props.setProperty("mail.user", mailParametersDTO.getUsername());
        props.setProperty("mail.password", mailParametersDTO.getPassword());
        props.setProperty("mail.smtp.host", mailParametersDTO.getHostname());
        props.setProperty("mail.smtp.port", mailParametersDTO.getPort());
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.port", mailParametersDTO.getPort());
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.mime.base64.ignoreerrors", "true");
        SMTPAuthenticator auth = new SMTPAuthenticator(mailParametersDTO.getUsername(), mailParametersDTO.getPassword());
        Session session = Session.getInstance(props, auth);//CAMBIADO POR CARLOS!
        return session;
    }
}
