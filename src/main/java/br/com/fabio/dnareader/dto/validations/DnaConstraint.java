package br.com.fabio.dnareader.dto.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DnaValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DnaConstraint {

    String message() default "DNA INVALIDO COM ANOTATION";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}