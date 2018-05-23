package com.tjlcast.scheduler;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class Demo00 {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4) // IO 线程，由 subsrcibeOn() 指定
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .map(num -> addOne(num))
            .observeOn(Schedulers.newThread())
            .subscribe(System.out::println) ;
    }

    private static int addOne(int num) {
        return num + 1 ;
    }
}
