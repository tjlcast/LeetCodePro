package com.tjlcast.demo;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by tangjialiang on 2018/5/22.
 */
public class demo00 {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                System.out.println(Thread.currentThread() + " observable") ;
                subscriber.onNext("hello, world");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(Thread.currentThread() + " subscriber") ;
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber) ;
    }
}
