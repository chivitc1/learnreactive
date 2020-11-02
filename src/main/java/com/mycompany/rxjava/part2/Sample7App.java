package com.mycompany.rxjava.part2;

import io.reactivex.Observable;

/**
 * fromCallable
 * initializing your emission has a likelihood of throwing an error
 *
 */
public class Sample7App
{
    public static void main( String[] args )
    {
        Observable<Integer> source = Observable.fromCallable(() -> 1/0);

        source.subscribe(item -> System.out.println(item),
                        e -> System.out.println("Error captured: " + e));
    }
}
