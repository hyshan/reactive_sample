package sample;

import rx.Observable;

public class Example07 {

    public static void main(String[] args) throws Exception {
        Observable<Long> now = Observable.just(System.currentTimeMillis());

        now.subscribe(s -> System.out.println(s));
        Thread.sleep(1000);
        now.subscribe(s -> System.out.println(s));

        Thread.sleep(1000);
        
        Observable<Long> deferNow = Observable.defer(
                () -> Observable.just(System.currentTimeMillis()));

        deferNow.subscribe(s -> System.out.println(s));
        Thread.sleep(1000);
        deferNow.subscribe(s -> System.out.println(s));
    }

}
