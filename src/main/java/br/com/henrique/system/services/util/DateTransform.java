package br.com.henrique.system.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTransform {

    public static Instant formatarData(String aux){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return fmt.parse(aux).toInstant();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String formatInstant(Instant instant) {
    	LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    	String formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	return formattedDate;
    }
}

