package de.consol.labs.aws.neptunedemoapp.common.crud.mapper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface Property {

    String value() default "";
}
