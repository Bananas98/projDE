package departmentmanagement.util;

public class JsonFormatter {
    public static String getJsonValue(String string) {
        return string.substring(string.indexOf('=')+1);
    }

}
