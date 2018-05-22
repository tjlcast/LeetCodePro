import java.lang.annotation.Annotation;

/**
 * Created by tangjialiang on 2018/5/22.
 */
@MyAnnotationC("bupt")
public class Main {

    public static void main(String[] args) {
        Annotation[] annotations = Main.class.getAnnotations();
        MyAnnotationC annotation = Main.class.getAnnotation(MyAnnotationC.class);
        Class<? extends Annotation> aClass = annotation.annotationType();

        System.out.println(aClass);
        System.out.println(annotation);

        for (Annotation a:
             annotations) {
            System.out.println(a) ;
        }
    }
}
