package pe.com.microdata.cjava.common.base;

import java.io.Serializable;
import java.util.List;

public class BusquedaDTO implements Serializable {

    private int inicio;//pagina de inicio

    private int cantidad;//cantidad de filas

    private String orden; // 

    private String ordenCampo;

    private List<CondicionDTO> condiciones;

    public BusquedaDTO() {
        inicio = -1;//-1 trae TODO
        cantidad = -1;// -1 trae TODO
        orden = Constants.ORD_NINGUNO;  //sin orden
    }

    public BusquedaDTO(int pagina, int cantidad) {
        this.inicio = pagina;
        this.cantidad = cantidad;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getOrdenCampo() {
        return ordenCampo;
    }

    public void setOrdenCampo(String ordenCampo) {
        this.ordenCampo = ordenCampo;
    }

    public List<CondicionDTO> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(List<CondicionDTO> condiciones) {
        this.condiciones = condiciones;
    }

   

   
}