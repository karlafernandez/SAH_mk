package pe.com.microdata.cjava.service.autocomplete.dto;

/**
 *
 * @author meliMeli
 */
public class AutocompleteDTO implements java.io.Serializable ,Comparable<AutocompleteDTO> {

     private Integer value;
     private String label;
  

    public AutocompleteDTO(){
    }

    @Override
    public int compareTo(AutocompleteDTO t) {
        Integer i = getValue();
        return i.compareTo(t.getValue());
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutocompleteDTO other = (AutocompleteDTO) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
}