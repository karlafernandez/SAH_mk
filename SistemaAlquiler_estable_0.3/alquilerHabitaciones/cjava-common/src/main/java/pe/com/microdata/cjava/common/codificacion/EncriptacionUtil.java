package pe.com.microdata.cjava.common.codificacion;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.apache.log4j.Logger;

/********************************************************************************************
    Fecha de creación: 27-12-2010
    Nombre: Jimmy Valverde Sanchez
    Descripción: Retorna el hexadecimal MD5 de un texto
Fuente: http://es.gravatar.com/site/implement/images/java/
    Actualizaciones:
    Fecha			Autor			Descripción
    ----------------------------------------------------------------------------------------

*********************************************************************************************/
public class EncriptacionUtil {

    public static Logger logger = Logger.getLogger(EncriptacionUtil.class);

    public static synchronized String generarCadena () {
        String diccionario = "QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR";
        StringBuffer cadena = new StringBuffer();
        Random num = new Random();
        int gosh = 0;
            for(int i = 1; i <= 5; i++) {
                gosh = num.nextInt(62);
                cadena.append(diccionario.charAt(gosh));
            }
        return cadena.toString();
    }

    public static String codificarSimple(String cadena) {
        return cadena;
    }

    public static String decodificarSimple (String codificado) {
        return codificado;
    }

    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    private static String md5Hex(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(message.getBytes("CP1252"))); //Windows-1252
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex);
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        return null;
    }

    public static String encriptar (String cadena) {
        return md5Hex(cadena);
    }
}