package com.mycompany.rxjava.part2;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Completable
 * execute the specified action before calling onComplete()
 * Have an action being executed, but it does not receive any emissions
 *
 */
public class Sample10App
{
    public static void main( String[] args )
    {
        Completable.fromRunnable(() -> runProcess())
                .subscribe(() -> System.out.println("Done!"));

    }

    static void runProcess() {
        System.out.println("Run something in 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
