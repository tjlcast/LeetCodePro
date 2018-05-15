package RxJava.Base;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by tangjialiang on 2018/4/21.
 */
public class Test01 {

    public static void main(String[] args) {
        String[] names = {"bupt", "tjlcast"} ;

        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s) ;
                    }
                }) ;
    }
}
