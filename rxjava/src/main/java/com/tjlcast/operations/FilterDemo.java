package com.tjlcast.operations;

import rx.Observable;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class FilterDemo {

    public static void main(String[] args) {
        query("Hello, world")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .subscribe(title -> System.out.println(title)) ;
    }

    private static Observable<String> getTitle(String url) {
        return null;
    }

    public static Observable<List<String>> query(String text) {
        return null ;
    }
}
