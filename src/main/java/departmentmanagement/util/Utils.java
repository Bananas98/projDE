package departmentmanagement.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
    public static Integer parseInteger(String stringInteger){
        Integer integer;
        try {
            integer = Integer.valueOf(stringInteger);
        }catch (NumberFormatException e){
            integer = null;
        }
        return integer;
    }
    public static Date parseDate(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = new Date(formatter.parse(stringDate).getTime());
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }

    public static boolean isNullOrEmpty(String s){
        return (s == null || s.length() == 0);
    }
}
