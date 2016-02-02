package sample;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class Example04 {

    public static void main(String[] args) throws Exception {

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(n -> System.out.println("A " + n));

        // 2nd subscriber starts 5 seconds later to emphasize independent
        // streams
        Thread.sleep(5000);

        observable.subscribe(n -> System.out.println(" B " + n));

        System.in.read();

    }

}
