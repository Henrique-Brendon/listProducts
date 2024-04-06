package br.com.henrique.system.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
    
    public static Instant format(String iso) {
    	DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
    	Instant instant = Instant.from(formatter.parse(iso));
    	return instant;
    }
}

