package pe.com.microdata.cjava.service.mail.dto;

public class MailParametersDTO {

    private String hostname;
    private String port;
    private String username;
    private String password;
    private String nicksender;
 

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicksender() {
        return nicksender;
    }

    public void setNicksender(String nicksender) {
        this.nicksender = nicksender;
    }

   
}