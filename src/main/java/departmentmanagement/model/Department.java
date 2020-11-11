package departmentmanagement.model;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.regex.Pattern;

public class Department {

//    @Override
//    public String execute()
//    {
//        if ((getName().trim().length() > 0)) {
//            return Action.SUCCESS;
//        }
//        return Action.INPUT;
//    }
//    @Override
//    public void validate()
//    {
//        if (isEmptyString(name))
//            addFieldError("name","Name is empty");
//        if (Pattern.matches("[a-zA-Z]+",name))
//            addFieldError("name","Name can contains only characters");
//        if (name.length() > 30) {
//            addFieldError ("name","Name is very long" );
//        }
//    }
//    private boolean isEmptyString (String value) {
//        return value == null || "".equals (value.trim ());
//    }

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }
    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
