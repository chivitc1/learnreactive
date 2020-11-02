package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Zip & slow down first Observable
 */
public class Sample8App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<String> source1 = Observable.just("a", "b", "c", "d");
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<String> source = Observable.zip(source1, source2, (first, second) -> first);
        source.subscribe(System.out::println);

        Thread.sleep(6000);
    }
}
