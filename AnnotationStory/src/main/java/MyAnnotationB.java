import java.lang.annotation.*;

/**
 * Created by tangjialiang on 2018/5/22.
 */

@Target({ElementType.ANNOTATION_TYPE})         // 指明该注解适用的范围
@Retention(RetentionPolicy.RUNTIME) // 什么时候使用该注解
@Documented
public @interface MyAnnotationB {
    int age() ;
}
