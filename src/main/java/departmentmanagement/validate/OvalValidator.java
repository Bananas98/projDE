package departmentmanagement.validate;


import departmentmanagement.exception.ValidException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OvalValidator {
    private Validator validator = new Validator();

    public void setValidator(Object o) throws ValidException {
        List<ConstraintViolation> constraintViolations = validator.validate(o);
        Map<String, String> map = new HashMap<>();
        if (!constraintViolations.isEmpty()){
            for (ConstraintViolation constraintViolation: constraintViolations){
                OValContext context = constraintViolation.getContext();
                if (context instanceof FieldContext){
                    Field fieldContext  = ((FieldContext) context).getField();
                    map.put(fieldContext.getName(), constraintViolation.getMessage());
                }
            }
            throw new ValidException(map);
        }

    }


}
