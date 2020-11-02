package com.mycompany.rxjava.part2;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Disposable
 * call dispose() to stop emissions and dispose of all resources used for that Observer
 *
 */
public class Sample11App
{
    public static void main( String[] args )
    {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = seconds.subscribe(
                item -> System.out.println("Received: " + item),
                Throwable::printStackTrace);

        sleep(5000);

        //dispose and stop emission
        disposable.dispose();

        //sleep 5 seconds to approve there are no more emissions
        sleep(5000);
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
