package com.tjlcast.operations;

import rx.Observable;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class MapDemo {

    public static void main(String[] args) {
        Observable.just("hello", "world")
                .map(s -> s.hashCode())
                .map(i -> Integer.toBinaryString(i))
                .subscribe(s -> System.out.println(s)) ;
    }
}
