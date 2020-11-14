package departmentmanagement.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {



    private Integer id;
    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 25)
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
