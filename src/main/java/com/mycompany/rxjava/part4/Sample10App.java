package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * withLatestFrom()
 *
 * with each emission from source2, combine with the latest emission from source1, skip other emission from source1
 */
public class Sample10App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<String> source = source2.withLatestFrom(source1,
                (first, second) -> "Source2: " + first + " Source1: " + second);
        source.subscribe(System.out::println);

        Thread.sleep(6000);
    }
}
