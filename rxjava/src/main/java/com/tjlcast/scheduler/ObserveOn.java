package com.tjlcast.scheduler;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class ObserveOn {

    public static void main(String[] args) {
        methodB() ;
    }

    public static void methodA() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        System.out.println("number: " + number) ;
                    }
                }) ;
    }

    public static void methodB() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("info1");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext("info2-sleep 2s");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext("info2-sleep 3s");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted()") ;
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError() e=" + e) ;
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                }) ;
    }
}
