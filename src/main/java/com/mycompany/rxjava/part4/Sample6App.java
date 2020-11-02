package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * First emitting observable win
 *
 */
public class Sample6App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> item + 1)
                .map(item -> "Source1: " + item + " seconds");

        // This observable wins as it is faster
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(item -> (item + 1) * 300)
                .map(item -> "Source2 : " + item + " milliseconds");
        Observable<String> source = Observable.amb(Arrays.asList(source1, source2));
        source.subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
