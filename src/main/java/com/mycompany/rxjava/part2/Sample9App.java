package com.mycompany.rxjava.part2;

import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * Maybe
 * only emit 0 or 1 emissions
 */
public class Sample9App
{
    public static void main( String[] args ) throws InterruptedException {
        //Has emission
        Maybe<Integer> mb1 = Maybe.just(100);
        mb1.subscribe(
                item -> System.out.println("Process 1 received: " + item),
                Throwable::printStackTrace,
                () -> System.out.println("Process 1 done!"));

        //No emission
        Maybe<Integer> mb2 = Maybe.empty();
        mb2.subscribe(item -> System.out.println("Process 2 received: " + item),
                Throwable::printStackTrace,
                () -> System.out.println("Process 2 done!"));

        Observable<String> source = Observable.just("1", "2", "3");
        Maybe<String> mb3 = source.firstElement();
        mb3.subscribe(
                item -> System.out.println("Process 3 received: " + item),
                Throwable::printStackTrace,
                () -> System.out.println("Process 3 done!"));

    }
}
