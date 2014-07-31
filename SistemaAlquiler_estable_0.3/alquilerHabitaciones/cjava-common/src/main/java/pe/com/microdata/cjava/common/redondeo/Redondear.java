package pe.com.microdata.cjava.common.redondeo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Redondear {

    public static final int ESCALA_REDONDEO_TRABAJO = 6;

    public static final int ESCALA_REDONDEO_VISTA = 2;

    public static BigDecimal redondearVista(BigDecimal numero) {
        BigDecimal bd = new BigDecimal((numero.setScale(ESCALA_REDONDEO_VISTA, RoundingMode.HALF_UP)).toString());
        return bd;
    }

    public static BigDecimal redondearTrabajo(BigDecimal numero) {
        BigDecimal bd = new BigDecimal((numero.setScale(ESCALA_REDONDEO_TRABAJO, RoundingMode.HALF_UP)).toString());
        return bd;
    }
}