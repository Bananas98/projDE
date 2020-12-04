package departmentmanagement.validate;


import departmentmanagement.exception.ValidException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OvalValidator {

    public void validate(Object o) throws ValidException {
        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        myConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);

        Validator validator = new Validator(myConfigurer);

        List<ConstraintViolation> violations = validator.validate(o);
        Map<String,String> map = new HashMap<>();

        if(!violations.isEmpty()){
            for(ConstraintViolation constraintViolation : violations){
                OValContext context = constraintViolation.getContext();
                if (context instanceof FieldContext) {
                    Field fieldContext = ((FieldContext) context).getField();
                    map.put(fieldContext.getName(), constraintViolation.getMessage());
                }
            }
            throw new ValidException(map);
        }

    }

}
