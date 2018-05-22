import java.lang.annotation.*;

/**
 * Created by tangjialiang on 2018/5/22.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyAnnotationA(name = "123")
@MyAnnotationB(age = 12)
public @interface MyAnnotationC {
    String value() ;
}
