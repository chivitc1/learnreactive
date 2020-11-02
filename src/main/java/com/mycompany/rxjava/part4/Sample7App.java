package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

/**
 * Zip
 *
 */
public class Sample7App
{
    public static void main( String[] args ) throws InterruptedException {
        Observable<String> source1 = Observable.just("a", "b", "c", "d");
        Observable<Integer> source2 = Observable.range(97, 4);
        Observable<String> source = Observable.zip(source1, source2, (first, second) -> first + "-" + second);
        source.subscribe(System.out::println);
    }
}
