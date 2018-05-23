package com.tjlcast.demo;

import rx.Observable;
import rx.Subscription;

/**
 * Created by tangjialiang on 2018/5/22.
 */
public class Demo01 {

    public static void main(String[] args) {
        Subscription subscription = Observable.just("hello", "world")
                .subscribe(System.out::println);// or s -> System.out.println(s)

        /**
         * unsubscribe(): 这是 Subscriber 所实现的另一个接口 Subscription 的方法，用于取消订阅。
         * 在这个方法被调用后，Subscriber 将不再接收事件。一般在这个方法调用前，可以使用 isUnsubscribed() 先判断一下状态。
         * unsubscribe() 这个方法很重要，因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
         * 这个引用如果不能及时被释放，将有内存泄露的风险。
         * 所以最好保持一个原则：要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）调用
         * unsubscribe() 来解除引用关系，以避免内存泄露的发生。
         */
        System.out.println(subscription.isUnsubscribed()) ;
    }
}
