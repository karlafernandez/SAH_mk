/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */
public class SIGAMessage {

    public static enum MessageType {

        SUCCESS, WARNING, ERROR
    };
    private MessageType messageType;
    private List<String> messages = new ArrayList<String>();
    private Serializable data;
    private Boolean success;

    public SIGAMessage(Boolean success) {
        this.success = success;
    }

    public SIGAMessage() {
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        setSuccess((Boolean) (messageType == MessageType.SUCCESS ? true : false));
        this.messageType = messageType;
    }

    public List getMessages() {
        return messages;
    }

    public void addMessages(String message) {
        this.messages.add(message);
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty() ? true : false;
    }
}
