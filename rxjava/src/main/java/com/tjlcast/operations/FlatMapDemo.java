package com.tjlcast.operations;

import rx.Observable;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class FlatMapDemo {

    /**
     * Observable<List<String>> query(String text) ;
     * @param args
     */
    public static void main(String[] args) {

        // methodA
        query("hello, world")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        return Observable.from(strings) ;
                    }
                })
                .subscribe(System.out::println) ;

        // methodB
        query("hello, world")
                .flatMap(urls -> Observable.from(urls))
                .subscribe(url -> System.out.println(url)) ;
    }

    public static Observable<List<String>> query(String text) {
        return null ;
    }
}
