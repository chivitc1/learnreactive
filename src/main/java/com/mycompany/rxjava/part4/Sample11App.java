package com.mycompany.rxjava.part4;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

/**
 * groupBy()
 * to group emissions by a specified key into separate Observables
 *  which emits a special type of Observable called GroupedObservable.
 *  GroupedObservable<K,T> is just like any other Observable
 */
public class Sample11App {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.just("1", "22", "333", "a", "b", "aa", "bb", "ccc");
        Observable<GroupedObservable<Integer, String>> source = source1.groupBy(item -> item.length());
        source.flatMapSingle(group ->
                group.reduce("", (x, y) -> x.equals("") ? y : x + ", " + y)
                        .map(item -> group.getKey() + ": " + item)
        ).subscribe(System.out::println);

    }
}
