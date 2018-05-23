package com.tjlcast.operations;

import rx.Observable;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class TakeDemo {

    public static void main(String[] args) {
        // 最多5个结果
        query("Hello, world")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(5)
                .subscribe(title -> System.out.println(title)) ;
    }

    private static Observable<String> getTitle(String url) {
        return null;
    }

    public static Observable<List<String>> query(String text) {
        return null ;
    }
}
