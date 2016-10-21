package annotation;

import java.lang.annotation.*;

/**
 * Created by lunhengle on 2016/9/29.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
public @interface PluginService {
    String filter() default "null";
    String version() default "";
}
