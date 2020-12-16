package departmentmanagement.model;


import departmentmanagement.validate.UniqueDepartmentName;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;
import javax.persistence.*;

@Entity
@Table(name = "department", schema = "department_employee")
public class Department extends BaseEntity{


    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    @CheckWith(value = UniqueDepartmentName.class, message ="This name of department has used")
    @Column(name = "name")
    private String name;

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


}
