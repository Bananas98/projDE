package departmentmanagement.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {



    private int id;
    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 25)
    private String name;

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

}
