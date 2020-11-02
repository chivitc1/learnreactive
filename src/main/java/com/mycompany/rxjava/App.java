package com.mycompany.rxjava;

import io.reactivex.Observable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Observable<String> strings = Observable.just("Alpha", "Beta", "Cesar", "Deka");

        strings.map(item -> item.length()).subscribe(item -> System.out.println(item));
    }
}
