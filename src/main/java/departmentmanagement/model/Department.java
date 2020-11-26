package departmentmanagement.model;


import departmentmanagement.validate.UniqueDepartmentName;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "department_employee")
public class Department {



    private Integer id;
    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    @CheckWith(value = UniqueDepartmentName.class, message ="This name of department has used")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
