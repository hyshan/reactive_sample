package sample;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.ConnectableObservable;

public class Example05 {

    public static void main(String[] args) throws Exception {

        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.subscribe(n -> System.out.println("A " + n));
        observable.connect();
        // 2nd subscriber starts 5 seconds later to emphasize independent
        // streams
        Thread.sleep(5000);

        observable.subscribe(n -> System.out.println(" B " + n));

        System.in.read();
    }

}
