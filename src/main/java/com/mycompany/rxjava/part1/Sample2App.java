package com.mycompany.rxjava.part1;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Time-based observable
 * emit consecutive long (start at 0) at every interval
 *
 */
public class Sample2App
{
    public static void main( String[] args )
    {
        Observable<Long> secondsInterval = Observable.interval(3, TimeUnit.SECONDS);

        secondsInterval.subscribe(item -> System.out.println(item));

        sleep(15000);
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
