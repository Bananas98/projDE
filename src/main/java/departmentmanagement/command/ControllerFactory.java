package departmentmanagement.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ControllerFactory {

    @Autowired
    private Map<String, Command> controllerFactory;

    public Map<String, Command> getControllerFactory() {
        return controllerFactory;
    }
}
