package com.cevichemadrileno.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase utilitaria para manejar fechas y horas
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class DateUtils {

    /**
     * Formatear la fecha de la actividad
     * Ejemplo: Miércoles, 01/10/2025
     *
     * @param date
     * @return string
     */
    public static String formatearFecha(Date date) {
        SimpleDateFormat diaSemanaFormat = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        SimpleDateFormat fechaCompletaFormat = new SimpleDateFormat("dd/MM/yyyy");

        String diaSemana = diaSemanaFormat.format(date);
        diaSemana = diaSemana.substring(0, 1).toUpperCase() + diaSemana.substring(1);

        String fecha = fechaCompletaFormat.format(date);

        return diaSemana + ", " + fecha;
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
