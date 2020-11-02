package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

/**
 * flatMap
 *
 * pass a second combiner argument, which is a BiFunction<T,U,R> lambda, to associate the originally emitted T value
 * with each flat-mapped U value and turn both into an R value
 */
public class Sample4App
{
    public static void main( String[] args )
    {
        Observable<String> source = Observable.just("Hello", "Morning", "Evening", "Night");

        Observable source2 = source.flatMap(item -> Observable.fromArray(item.split("")),
                (s, r) -> s + "-" + r);
        source2.subscribe(System.out::println);
    }
}
