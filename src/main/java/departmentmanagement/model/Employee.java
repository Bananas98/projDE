package departmentmanagement.model;


import departmentmanagement.validate.UniqueEmployeeEmail;
import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "department_employee")
public class Employee{

    private Integer id;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "cannot be empty")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    private String name;

    @NotNull(message = "Enter date!")
    @NotEmpty(message = "Enter date!")
    private Date dateOfBirthday;

    @NotNull
    @NotEmpty
    @Email(message = "incorrect email")
    @CheckWith(value = UniqueEmployeeEmail.class, message = "This e-mail has used, put other e-mail")
    private String mail;

    @NotNull(message = "Enter salary!")
    @NotEmpty(message = "Enter salary!")
    @Min(value = 0, message = "Salary is incorrect!")
    @Digits(message = "only digits")
    private Integer salary;

    @NotNull(message = "department cannot be null")
    @NotEmpty(message = "cannot be empty")
    private Integer idDepartment;
    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "dateOfBirthday")
    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "id_department")
    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    @ManyToOne
    @JoinColumn(name = "id_department", insertable = false, updatable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (!Objects.equals(id, that.id)) return false;
        if (Double.compare(that.salary, salary) != 0) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(dateOfBirthday, that.dateOfBirthday))
            return false;
        return Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirthday != null ? dateOfBirthday.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
                ", department=" + department +
                '}';
    }
}
