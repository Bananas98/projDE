package departmentmanagement.util;

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
}
