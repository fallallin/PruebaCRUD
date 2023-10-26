package com.example.PruebaCRUD.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    /**
     * Convertir de String a java.util.Date
     *
     * @param strDate
     * @return
     */
    public static Date convertStringToDate(String strDate) {

        Date fechaComoDate = null;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parsea la cadena a un objeto java.util.Date
            fechaComoDate = formato.parse(strDate);

        } catch (Exception e) {
            fechaComoDate = new Date();
        }

        return fechaComoDate;
    }
}
