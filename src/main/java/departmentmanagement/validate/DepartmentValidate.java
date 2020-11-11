package departmentmanagement.validate;

public class DepartmentValidate {
    private static final String  VALID_NAME_REGEX="[A-Za-z]{3,30}";

    public boolean checkName(String name){
        return name.matches(VALID_NAME_REGEX);
    }

}
