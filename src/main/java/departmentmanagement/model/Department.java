package departmentmanagement.model;


import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

public class Department {



    private Integer id;
    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 25, message = "enter a word between 3 and 25 characters long")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
