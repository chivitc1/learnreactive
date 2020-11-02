package com.mycompany.rxjava.part5;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Multicast
 *force emissions from the source to become hot, pushing a single stream of
 * emissions to all Observers at the same time rather than giving a separate stream to each Observer
 */
public class Sample1App
{
    public static void main( String[] args )
    {
        ConnectableObservable<Integer> source = Observable.range(1, 4).publish();

        source.subscribe(item -> System.out.println(item));
        source.subscribe(item -> System.out.println(item));

        source.connect();
    }
}
