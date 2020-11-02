package com.mycompany.rxjava.part5;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Multicast
 *force emissions from the source to become hot, pushing a single stream of
 * emissions to all Observers at the same time rather than giving a separate stream to each Observer
 *
 * helpful in preventing redundant work being done by multiple Observers and instead makes
 * all Observers subscribe to a single stream, at least to the point where they have operations in common.
 * You may do this to increase performance, reducing memory and CPU usage, or simply because your
 * business logic requires pushing the same emissions to all Observers
 *
 * Data-driven cold Observables should only be multicast when you are doing so for performance reasons
 * and have multiple Observers receiving the same data simultaneously
 *
 * Remember that multicasting creates
 * hot ConnectableObservables, and you have to be careful and time the connect() call so data is not missed by
 * Observers
 *
 * find the proxy point where you can multicast and consolidate the upstream operations - typically the boundary
 * where Observers have common operations upstream and diverge into
 * different operations downstream
 */
public class Sample2App
{
    public static void main( String[] args )
    {
        //Two separate streams emit
        Observable<Integer> source = Observable.range(1, 3).map(item -> randomInt());

        source.subscribe(item -> System.out.println("Observer 1: " + item));
        source.subscribe(item -> System.out.println("Observer 2: " + item));

        //Multicast
        ConnectableObservable source2 = source.publish();

        source2.subscribe(item -> System.out.println("Observer 3: " + item));
        source2.subscribe(item -> System.out.println("Observer 4: " + item));

        source2.connect();
    }

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
