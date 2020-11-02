package com.mycompany.rxjava.part5;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Multicast
 *
 * We know in advance how many subscriptions
 * No need to call connect()
 */
public class Sample3App
{
    public static void main( String[] args )
    {
        //Two separate streams emit
        Observable<Integer> source = Observable.range(1, 3)
                .map(item -> randomInt()).publish().autoConnect(2);

        source.subscribe(item -> System.out.println("Observer 1: " + item));
        source.reduce(0, (total, next) -> total + next)
                .subscribe(item -> System.out.println("Observer 2: " + item));
    }

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt(10);
    }
}
