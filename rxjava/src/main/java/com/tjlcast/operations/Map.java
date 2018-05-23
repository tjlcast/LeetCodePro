package com.tjlcast.operations;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import sun.jvm.hotspot.utilities.BitMap;

/**
 * Created by tangjialiang on 2018/5/23.
 */
public class Map {

    public static void main(String[] args) {
        Observable.just("images/logo.png")
                .map(new Func1<String, BitMap>() {
                    @Override
                    public BitMap call(String filePath) {
                        return getBitmapFromPath(filePath) ; //
                    }
                })
                .subscribe(new Action1<BitMap>() {
                    @Override
                    public void call(BitMap bitMap) {
                        showBitmap(bitMap) ;
                    }
                }) ;


        Observable.just("images/logo.png")
                .map(filePath -> getBitmapFromPath(filePath))
                .subscribe(bitMap -> showBitmap(bitMap)) ;
    }

    public static BitMap getBitmapFromPath(String filePath) {
        return null ;
    }

    public static void showBitmap(BitMap bitMap) {

    }
}
