package com.mycompany.rxjava.part5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Multicast
 *
 * The emission not start until last subscriber created
 */
public class Sample4App
{
    public static void main( String[] args ) throws InterruptedException {
        //Two separate streams emit
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                .publish().autoConnect(2);

        source.subscribe(item -> System.out.println("Observer 1: " + item));
        Thread.sleep(3000);

//        source.subscribe(item -> System.out.println("Observer 2: " + item));
//        Thread.sleep(3000);
    }

}
