package departmentmanagement.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


public class Employee{

    private Integer id;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "cannot be empty")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    private String name;
    private Date dateOfBirthday;
    private String mail;
    private Integer salary;
    private Integer idDepartment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

}
