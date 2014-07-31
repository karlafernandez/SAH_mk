package pe.com.microdata.cjava.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReglaDTO implements Serializable {

    private List<String> fields;

    private String data;

    private int op;

    private int type;

    private int logica;

    public ReglaDTO() {
    }

    public ReglaDTO(int op, int type, String field) {
        this.fields = new ArrayList<String>();
        fields.add(field);
        this.op = op;
        this.type = type;
        this.logica = Constants.LOG_AND;

    }

    public ReglaDTO(int op, int type, int logica, String... fields) {
        this.fields = Arrays.asList(fields);
        this.op = op;
        this.type = type;
        this.logica = logica;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLogica() {
        return logica;
    }

    public void setLogica(int logica) {
        this.logica = logica;
    }
}