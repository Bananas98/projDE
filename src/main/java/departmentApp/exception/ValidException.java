package departmentApp.exception;

import java.util.Map;

public class ValidException extends Exception {

    private final Map<String , String> errors;

    public ValidException(Map<String,String> errors){
        this.errors = errors;
    }

    public Map<String, String> getMapError() {
        return errors;
    }
}
