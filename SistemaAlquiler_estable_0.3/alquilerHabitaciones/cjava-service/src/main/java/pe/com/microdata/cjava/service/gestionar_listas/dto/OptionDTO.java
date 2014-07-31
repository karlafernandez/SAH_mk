package pe.com.microdata.cjava.service.gestionar_listas.dto;

import java.io.Serializable;
import pe.com.microdata.cjava.common.base.BaseDTO;

public class OptionDTO  extends BaseDTO implements Serializable {
    private Integer id;
    private String name;

    public OptionDTO() {
    }

    public OptionDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}