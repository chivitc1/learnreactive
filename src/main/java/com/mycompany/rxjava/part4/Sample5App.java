package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * concat
 * merged Observables fire their emissions in a guaranteed order.
 *
 *  it will fire elements of each provided Observable sequentially and in the order specified.
 *  It will not move on to the next Observable until the current one calls onComplete()
 */
public class Sample5App
{
    public static void main( String[] args ) throws InterruptedException {

        Observable<String> source1 = Observable.just("1", "2", "3", "4", "5");
        Observable<String> source2 = Observable.just("a", "b", "c", "d", "e", "f");
        Observable<String> source = Observable.concat(source1, source2);
        source.subscribe(System.out::println);
    }
}
