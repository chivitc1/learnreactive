package com.mycompany.rxjava.part3;

import io.reactivex.Observable;

/**
 * Hello world!
 *
 */
public class Sample12App
{
    public static void main( String[] args )
    {
        Observable<String> strings = Observable.just("Alpha", "Beta", "Cesar", "Deka");

        strings.map(item -> item.length()).subscribe(item -> System.out.println(item));
    }
}
