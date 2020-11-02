package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * merge observables
 *
 */
public class Sample1App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> item + 1)
                .map(item -> "Source1: " + item + " seconds");
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(item -> (item + 1) * 300)
                .map(item -> "Source2 : " + item + " milliseconds");
        Observable<String> combine = Observable.merge(source1, source2);
        combine.subscribe(System.out::println);


        Observable<String> source3 = Observable.just("1", "2", "3", "4", "5");
        Observable<String> source4 = Observable.just("a", "b", "c", "d", "e", "f");
        Observable<String> noOrderCombine = Observable.merge(source3, source4);
//        noOrderCombine.subscribe(System.out::println);

        Thread.sleep(9000);
    }
}
