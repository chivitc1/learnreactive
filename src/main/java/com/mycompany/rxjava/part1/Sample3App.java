package com.mycompany.rxjava.part1;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Sample3App
{
    public static void main( String[] args )
    {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gama");
            emitter.onComplete();
        });

        source.subscribe(s -> System.out.println(s));

    }
}
