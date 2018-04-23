package RxJava.Base;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by tangjialiang on 2018/4/21.
 */
public class Test00 {

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            System.out.println("onCompleted") ;
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("onError: " + throwable) ;
        }

        @Override
        public void onNext(String s) {
            System.out.println("onNext: " + s);
        }
    } ;

    Subscriber<String> subscriber = new Subscriber<String>() {
        /**
         * Observer 也总是会先被转换成一个 Subscriber 再使用
         */
        @Override
        public void onCompleted() {
            System.out.println("onCompleted") ;
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("onError: " + throwable) ;
        }

        @Override
        public void onNext(String s) {
            System.out.println("onNext: " + s);
        }
    } ;

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello ");
            subscriber.onNext("I ");
            subscriber.onNext(" am ");
            subscriber.onNext("RxJava");
            subscriber.onCompleted();
        }
    }) ;

    public static void main(String[] args) {

    }
}
