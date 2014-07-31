package pe.com.microdata.cjava.common.base;

import java.io.Serializable;

public class BaseDTO implements Serializable {
    String valMensaje;
    Integer idUsuario;

    public String getValMensaje() {
        return valMensaje;
    }

    public void setValMensaje(String valMensaje) {
        this.valMensaje = valMensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}