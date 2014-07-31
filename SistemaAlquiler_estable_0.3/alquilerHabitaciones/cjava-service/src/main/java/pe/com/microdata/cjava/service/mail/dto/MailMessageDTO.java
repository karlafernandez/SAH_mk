/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.mail.dto;

import java.util.List;

/**
 *
 * @author Alejandra Gonzales
 */
public class MailMessageDTO {

    String asunto;

    String mensaje;

    String receptores;

    Boolean esMensajeHTML = true;

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getReceptores() {
        return receptores;
    }

    public void setReceptores(String receptores) {
        this.receptores = receptores;
    }

    public Boolean getEsMensajeHTML() {
        return esMensajeHTML;
    }

    public void setEsMensajeHTML(Boolean esMensajeHTML) {
        this.esMensajeHTML = esMensajeHTML;
    }
}
