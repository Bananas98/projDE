package departmentApp.exception;

public class UserSqlException extends RuntimeException {
    public UserSqlException(Throwable cause){
        super(cause);
    }
}