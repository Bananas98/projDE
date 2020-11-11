package departmentmanagement.model;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.util.regex.Pattern;

public class Employee{
    private int id;
    private String name;
    private Date dateOfBirthday;
    private String mail;
    private int salary;
    private int idDepartment;

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

    private boolean isEmptyString (String value) {
        return value == null || "".equals (value.trim ());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", mail='" + mail + '\'' +
                ", salary=" + salary +
                ", idDepartment=" + idDepartment +
                '}';
    }
}
