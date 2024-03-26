package br.com.henrique.system.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

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
}

