package com.cevichemadrileno.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    /**
     * Obtiene el dia y el día de la semana a partir de una fecha.
     * Ejemplo: Miércoles, 21
     *
     * @param date
     * @return string
     */
    public static String obtenerDiayDiaSemana(Date date) {
        SimpleDateFormat diaSemanaFormat = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        SimpleDateFormat diaMesFormat = new SimpleDateFormat("d", new Locale("es", "ES"));

        String diaSemana = diaSemanaFormat.format(date);
        diaSemana = diaSemana.substring(0, 1).toUpperCase() + diaSemana.substring(1);

        String diaMes = diaMesFormat.format(date);

        return diaSemana + ", " + diaMes;
    }


    /**
     * Obtiene la hora a partir de una fecha
     *
     * @param date
     * @return string con la hora formateada en formato HH:MM - HH:MM
     */
    public static String obtenerHora(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", new Locale("es", "ES"));
        int hora = Integer.parseInt(simpleDateFormat.format(date));
        return String.format("%02d:00", hora) + " - " + String.format("%02d:00", hora + 1);
    }
}
