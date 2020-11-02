package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * combineLatest()
 *
 * when one source fires, it couples with the latest emissions from the others.
 *
 * similar to zip(), but for every emission that fires from one
 * of the sources, it will immediately couple up with the latest emission from every other source
 *
 * especially helpful in combining UI inputs, as previous user inputs are frequently
 * irrelevant and only the latest is of concern
 */
public class Sample9App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<String> source = Observable.combineLatest(source1, source2,
                (first, second) -> "Source1: " + first + " Source2: " + second);
        source.subscribe(System.out::println);

        Thread.sleep(6000);
    }
}
