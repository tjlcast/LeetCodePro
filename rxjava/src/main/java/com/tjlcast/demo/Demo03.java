package com.tjlcast.demo;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class Demo03 {

    public static void main(String[] args) {
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s) ;
            }
        } ;

        Observable<String> just = Observable.just("hello", "world");
        just.subscribe(onNextAction) ;

        Observable.just("hello", "world")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s) ;
                    }
                }) ;
    }
}
