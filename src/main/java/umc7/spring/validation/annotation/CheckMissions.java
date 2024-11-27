package umc7.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc7.spring.validation.validator.MissionsCheckValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionsCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMissions {
    String message() default "해당 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
