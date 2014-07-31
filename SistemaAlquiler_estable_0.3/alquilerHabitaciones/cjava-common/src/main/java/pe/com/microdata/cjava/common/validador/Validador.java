/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.common.validador;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;


public class Validador {

//    private static final String regexAlfanumerico = "^[a-zA-Z0-9]{%i,}$";
    private static final String regexAlfanumerico = "[a-zA-Z0-9]{%d}";
    private static final String regexSoloLetras = "^[a-zA-ZÑñ\\s]*";
    private static final String regexSoloNumeros = "^([0-9])*$";
    private static final String regexEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String regexPorcentaje = "^100?|(^[\\d]{0,2}?)(\\.([0-9])+)?";
    private static final String regexHora = "(([0-1][0-9])|(2[0-3])):[0-5][0-9]";

    public static boolean noNuloNoVacio(String test) {
        return (test != null) && !(test.trim().isEmpty());
    }

    public static boolean noNulo(Object test) {
        return (test != null);
    }

    public static boolean esAlfanumerico(String test, int longitudMinima) {
        return (Pattern.matches(String.format(regexAlfanumerico, longitudMinima), test));
    }

    public static boolean esEmail(String test) {
        return (Pattern.matches(regexEmail, test));
    }

    public static boolean esHora(String test) {
        return Pattern.matches(regexHora, test);
    }

    public static boolean esCero(Integer test) {
        return (test != null) && (test == 0);
    }

    public static boolean esMayorCero(Integer test) {
        return (test != null) && (test > 0);
    }

    public static boolean esMayorIgualCero(Integer test) {
        return (test != null) && (test >= 0);
    }

    public static boolean esCero(BigInteger test) {
        return (test != null) && (test.compareTo(BigInteger.ZERO) == 0);
    }

    public static boolean esMayorCero(BigInteger test) {
        return (test != null) && (test.compareTo(BigInteger.ZERO) > 0);
    }

    public static boolean listaNoVacia(List test) {
        return (test != null && !test.isEmpty());
    }

    public static boolean esFecha(String test, String formatoFecha) {
        boolean correcto = false;
        try {
            if ((test != null) && !(test.trim().isEmpty())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);
                dateFormat.parse(test);
                correcto = true;
            }
        } catch (Exception e) {
            correcto = false;
        }
        return correcto;

    }

    public static boolean esNumeroPlaca(String test) {
        String regexNumeroPlaca = "^([A-Z0-9]+\\-[A-Z0-9]+)$";
        return (Pattern.matches(regexNumeroPlaca, test));
    }

    public static boolean contieneSoloLetras(String test) {
        if (noNuloNoVacio(test)) {
            return (Pattern.matches(regexSoloLetras, test));
        } else {
            return false;
        }

    }

    public static boolean contieneSoloNumeros(String test) {
        if (noNuloNoVacio(test)) {
            return (Pattern.matches(regexSoloNumeros, test));
        } else {
            return false;
        }

    }
    //Esto no funciona del todo creo, pero hace lo que quiero =D

    public static boolean esPorcentaje(String test) {
        return (Pattern.matches(regexPorcentaje, test));
    }

    public static boolean esMayorCero(BigDecimal test) {
        return (test != null) && (test.compareTo(BigDecimal.ZERO) > 0);
    }

    public static boolean tamanhoMaximo(String test, int max) {
        return test.length() <= max;
    }

    public static boolean esNumero(String test) {
        boolean correcto = false;
        try {
            if ((test != null) && !(test.trim().isEmpty())) {
                Float num = Float.parseFloat(test) ;
                correcto = true;
            }
        } catch (NumberFormatException e) {
            correcto = false;
        }
        return correcto;
    }
}
