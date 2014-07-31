/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.util;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.common.validador.Validador;

/**
 *
 * @author alejandra
 */

public class GeneradorRestricciones {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);

    public static Criterion generar(ReglaDTO regla) {

        Junction junction = null;
        try {
            if (Validador.noNuloNoVacio(regla.getData())) {
                if (regla.getLogica() == Constants.LOG_OR) {
                    junction = Restrictions.disjunction();
                    for (String field : regla.getFields()) {
                        junction.add(crearCriterio(field, regla.getData(), regla.getType(), regla.getOp()));
                    }
                }

                if (regla.getLogica() == Constants.LOG_AND) {
                    junction = Restrictions.conjunction();
                    for (String field : regla.getFields()) {
                        junction.add(crearCriterio(field, regla.getData(), regla.getType(), regla.getOp()));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error al generar restriccion");

        }
        return junction;
    }

    private static Criterion crearCriterio(String field, String data, int type, int op) throws ParseException {
        Criterion criterio = null;

        //EQUAL
        if (op == Constants.OPE_EQ && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.eq(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_EQ && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.eq(field, new BigInteger(data));
        }
        if (op == Constants.OPE_EQ && type == Constants.TYPE_CHARACTER) {
            criterio = Restrictions.eq(field, new Character(data.charAt(0)));
        }

        if (op == Constants.OPE_EQ && type == Constants.TYPE_STRING) {
            criterio = Restrictions.ilike(field, data);
        }

        if (op == Constants.OPE_LIKE && type == Constants.TYPE_STRING) {
            criterio = Restrictions.ilike(field, "%" + data + "%");
        }

        if (op == Constants.OPE_LIKE_INICIO && type == Constants.TYPE_STRING) {
            criterio = Restrictions.ilike(field, data + "%");
        }

        if (op == Constants.OPE_EQ && type == Constants.TYPE_DATE) {
            criterio = Restrictions.eq(field, dateFormat.parse(data));
        }

        if (op == Constants.OPE_EQ && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            criterio = Restrictions.eq(field, c);
        }

        //LESS THAN OR EQUAL
        if (op == Constants.OPE_LE && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.le(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_LE && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.le(field, new BigInteger(data));
        }

        if (op == Constants.OPE_LE && type == Constants.TYPE_DATE) {
            criterio = Restrictions.le(field, dateFormat.parse(data));
        }

        if (op == Constants.OPE_LE && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            c.add(Calendar.DATE, 1);
            criterio = Restrictions.le(field, c);
        }

        //GREATHER THAN OR EQUAL
        if (op == Constants.OPE_GE && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.ge(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_GE && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.ge(field, new BigInteger(data));
        }

        if (op == Constants.OPE_GE && type == Constants.TYPE_DATE) {
            criterio = Restrictions.ge(field, dateFormat.parse(data));
        }
        if (op == Constants.OPE_GE && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            c.setTime(dateFormat.parse(data));
            criterio = Restrictions.ge(field, c);
        }

        //NO EQUAL
        if (op == Constants.OPE_NE && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.ne(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_NE && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.ne(field, new BigInteger(data));
        }

        if (op == Constants.OPE_NE && type == Constants.TYPE_STRING) {
            criterio = Restrictions.ne(field, data);
        }

        if (op == Constants.OPE_NE && type == Constants.TYPE_DATE) {
            criterio = Restrictions.ne(field, dateFormat.parse(data));
        }
        if (op == Constants.OPE_NE && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            criterio = Restrictions.ne(field, c);
        }

        //LESS THAN
        if (op == Constants.OPE_LT && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.lt(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_LT && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.lt(field, new BigInteger(data));
        }

        if (op == Constants.OPE_LT && type == Constants.TYPE_DATE) {
            criterio = Restrictions.lt(field, dateFormat.parse(data));
        }

        if (op == Constants.OPE_LT && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            c.add(Calendar.DATE, 1);
            criterio = Restrictions.lt(field, c);
        }

        //GREATHER THAN
        if (op == Constants.OPE_GT && type == Constants.TYPE_INTEGER) {
            criterio = Restrictions.gt(field, Integer.parseInt(data));
        }

        if (op == Constants.OPE_GT && type == Constants.TYPE_BIG_INTEGER) {
            criterio = Restrictions.gt(field, new BigInteger(data));
        }

        if (op == Constants.OPE_GT && type == Constants.TYPE_DATE) {
            criterio = Restrictions.gt(field, dateFormat.parse(data));
        }
        if (op == Constants.OPE_GT && type == Constants.TYPE_CALENDAR) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            c.setTime(dateFormat.parse(data));
            criterio = Restrictions.gt(field, c);
        }

        //OP NULL
        if (op == Constants.OPE_NULL) {
            if (data.equals("null")) {
                criterio = Restrictions.isNull(field);

            } else {
                criterio = Restrictions.isNotNull(field);
            } 
        }

        return criterio;
    }
}
