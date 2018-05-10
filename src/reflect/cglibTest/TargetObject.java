package reflect.cglibTest;

/**
 * Created by tangjialiang on 2018/5/6.
 */
public class TargetObject {

    public String method1(String parentName) {
        return parentName ;
    }

    public int method2(int count) {
        return count ;
    }

    public int method3(int count) {
        return count ;
    }

    @Override
    public String toString() {
        return "TragetObject {}" + getClass() ;
    }
}
