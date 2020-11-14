package departmentmanagement.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidException extends Exception {

    private Map<String , String> mapError = new HashMap<>();

    public ValidException(Map<String,String> mapError){
        this.mapError = mapError;
    }

    public Map<String, String> getMapError() {
        return mapError;
    }
}
