package com.tjlcast.operations;

import rx.Observable;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class DoOnNextDemo {

    /**
     * 在打印之前，把每个标题保存到磁盘：
     * @param args
     */
    public static void main(String[] args) {
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(5)
                .doOnNext(title -> saveTitle(title)) // doOnNext()允许我们在每次输出一个元素之前做一些额外的事情，比如这里的保存标题。
                .subscribe(title -> System.out.println(title));
    }

    private static Observable<String> getTitle(String url) {
        return null;
    }

    private static Observable<List<String>> query(String text) {
        return null ;
    }

    private static String saveTitle(String title) {
        return null ;
    }
}
