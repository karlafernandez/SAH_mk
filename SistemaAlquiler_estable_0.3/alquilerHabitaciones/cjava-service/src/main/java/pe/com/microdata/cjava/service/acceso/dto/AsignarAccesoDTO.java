package pe.com.microdata.cjava.service.acceso.dto;

import java.util.List;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;

public class AsignarAccesoDTO {

    private Integer idUsuario;
    private String direccionRetorno;
    UserDetailsDTO usuarioDTO;

    private List<Integer> lstAccesos;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UserDetailsDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UserDetailsDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public List<Integer> getLstAccesos() {
        return lstAccesos;
    }

    public void setLstAccesos(List<Integer> lstAccesos) {
        this.lstAccesos = lstAccesos;
    }

    public String getDireccionRetorno() {
        return direccionRetorno;
    }

    public void setDireccionRetorno(String direccionRetorno) {
        this.direccionRetorno = direccionRetorno;
    }
    
    

}
