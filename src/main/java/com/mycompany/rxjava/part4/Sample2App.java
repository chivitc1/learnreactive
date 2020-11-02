package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

/**
 * flatMap
 *
 * map one emission to many emissions
 *
 * The flatMap() expects each emission to yield an Observable,
 * and it will merge all the resulting Observables and emit their values in a single stream
 */
public class Sample2App
{
    public static void main( String[] args )
    {
        // * emit the characters from each string coming from Observable<String>
        Observable<String> source = Observable.just("Hello", "Morning", "Evening", "Night");

        Observable source2 = source.flatMap(item -> Observable.fromArray(item.split("")));
        source2.subscribe(System.out::println);
    }
}
