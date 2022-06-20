package br.com.furafila.stockapp.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.furafila.stockapp.validator.OutgoingReasonValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = OutgoingReasonValidator.class)
public @interface OutgoingReason {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
