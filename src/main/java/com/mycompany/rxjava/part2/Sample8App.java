package com.mycompany.rxjava.part2;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Single
 * emit only 1 item then complete
 *
 */
public class Sample8App
{
    public static void main( String[] args )
    {
        Observable<String> source = Observable.just("Alpha", "Beta", "Cesar", "Deka");
        Single<String> single1 = source.first("NIL");
        single1.subscribe(item -> System.out.println(item));

        Single<Integer> single2 = Single.just(100);
        single2.subscribe(item -> System.out.println("Received: " + item));


    }
}
