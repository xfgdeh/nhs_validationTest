package com.nhs_test.validator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AmountValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Amount {


    String message() default "{Amount}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
