package com.mycompany.rxjava.part4;

import io.reactivex.Observable;

/**
 * flatMap
 *
 * map one emission to many emissions
 *
 * The flatMap() expects each emission to yield an Observable,
 * and it will merge all the resulting Observables and emit their values in a single stream
 */
public class Sample3App
{
    public static void main( String[] args )
    {
        // extract numbers
        Observable<String> source3 =
                Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO", "283242/4542/WHISKEY/2348562");
        Observable source4 = source3.flatMap(item -> Observable.fromArray(item.split("/")))
                .filter(item -> item.matches("[0-9]+"))
                .map(Integer::valueOf);
        source4.subscribe(System.out::println);
    }
}
