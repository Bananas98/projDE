package departmentmanagement.validate;


import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidate {

    private static final String  VALID_NAME_REGEX="[A-Za-z]{3,30}";
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

//    public boolean validateEmployee(String name,String email,Date date,int salary){
//        return name.matches(VALID_NAME_REGEX);
//
//    }
//

    public boolean checkName(String name){
        return name.matches(VALID_NAME_REGEX);
    }

    public boolean checkEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    public boolean checkDate(Date date){
        String data = String.valueOf(date);
        String [] tmp = data.split("-");
        int year = Integer.parseInt(tmp[0]);
        return year >= 1900;
    }

    public boolean checkSalary(int salary){
        return salary >= 0;
    }


}
