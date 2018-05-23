package com.tjlcast.demo;


import rx.Observable;
import rx.functions.Func0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2018/5/22.
 */
public class Demo02 {

    public static void main(String[] args) {

        // 创建一个只发出一个事件就结束的Observable的对象。
        Observable<String> just = Observable.just("Hello, world!");

        // 遍历集合，发送每个item
        List<String> list = new ArrayList<>() ;
        list.add("form1") ;
        list.add("form2") ;
        list.add("form3") ;
        Observable<String> from = Observable.from(list);


        // 有观察者订阅时才创建Observable
        Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("deferObservable") ;
            }
        }) ;

        // 创建一个按固定时间间隔发射整数序列的Observable
        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);//每隔一秒发送一次

        // 创建一个发射特定整数序列的Observable，第一个参数为起始值，第二个为发送的个数
        Observable<Integer> range = Observable.range(10, 5);//将发送整数10，11，12，13，14

        // 在一个给定的延迟后发射一个特殊的值
        Observable<Long> timer = Observable.timer(3, TimeUnit.SECONDS);//3秒后发射一个值

        // 创建一个重复发射特定数据的Observable
        Observable<String> repeatObservable = Observable.just("repeatObservable").repeat(3);//重复发射3次

    }
}
