package departmentmanagement.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidException extends Exception {

    private Map<String , String> mapError;

    public ValidException(String message, Map<String,String> mapError){
        super(message);
        this.mapError = mapError;
    }

    public Map<String, String> getMapError() {
        return mapError;
    }
}
