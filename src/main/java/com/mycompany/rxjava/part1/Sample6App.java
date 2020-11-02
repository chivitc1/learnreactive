package com.mycompany.rxjava.part1;

import io.reactivex.observables.ConnectableObservable;

/**
 * ConnectableObservable - a hot Observable example
 *It will take any Observable, even if it is cold, and
 * make it hot so that all emissions are played to all Observers at once
 * force each emission to go to all Observers simultaneously is known as multicasting
 * consolidates all the upstream operations before publish() into a single stream
 */
public class Sample6App
{
    public static void main( String[] args )
    {
        ConnectableObservable<String> source = ConnectableObservable.just("333", "4444", "22", "55555", "666666").publish();

        source.subscribe(item -> System.out.println("Observer 1: " + item));
        source.map(item -> item.length()).subscribe(item -> System.out.println("Observer 2:" + item));

        source.connect();
    }
}
