package departmentApp.model;


import departmentApp.validate.UniqueEmployeeEmail;
import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee", schema = "department_employee")
public class Employee extends BaseEntity {

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "cannot be empty")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Enter date!")
    @NotEmpty(message = "Enter date!")
    @Column(name = "date_Of_Birthday")
    private Date dateOfBirthday;

    @NotNull
    @NotEmpty
    @Email(message = "incorrect email")
    @CheckWith(value = UniqueEmployeeEmail.class, message = "This e-mail has used, put other e-mail")
    @Column(name = "mail")
    private String mail;

    @NotNull(message = "Enter salary!")
    @NotEmpty(message = "Enter salary!")
    @Min(value = 0, message = "Salary is incorrect!")
    @Digits(message = "only digits")
    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;

    public Integer getId() {
        return super.getId();
    }

    public void setId(Integer id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
