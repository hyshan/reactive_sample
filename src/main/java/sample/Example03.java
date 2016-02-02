package sample;

import rx.Observable;
import rx.Subscriber;

public class Example03 {

    public static void main(String[] args) {

        // The OnSubscribe interface is a functional interface with one method
        // that takes one argument of type Subscriber<T> and returns nothing. 
        
        // OnSubscribe call method will be invoked each time a new Observer
        // subscribes to the Observable.
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                // IntStream.rangeClosed(1, 10).forEach(number ->
                // subscriber.onNext(number));
                for (int i = 1; i <= 10; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });
        observable.subscribe(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onError(Throwable e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNext(Integer t) {
                System.out.println(t);
            }
        });
    }
}
