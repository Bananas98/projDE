package departmentmanagement.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidException extends Exception {

    private Map<String , String> errors;

    public ValidException(Map<String,String> errors){
        this.errors = errors;
    }

    public Map<String, String> getMapError() {
        return errors;
    }
}
