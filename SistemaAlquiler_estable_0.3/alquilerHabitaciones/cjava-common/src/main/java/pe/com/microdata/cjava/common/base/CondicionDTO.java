/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.common.base;

/**
 *
 * @author Alejandra Gonzales
 */
public class CondicionDTO {

    private String data;

    private String field;

    public CondicionDTO() {
    }

    public CondicionDTO(String field, String data) {
        this.data = data;
        this.field = field;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
