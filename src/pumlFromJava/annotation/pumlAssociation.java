package pumlFromJava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface pumlAssociation {
    String Name() default "";
    DirectionEnum Direction() default DirectionEnum.SAME;
}

