package sample;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class Example02 {

    public static void main(String[] args) {
        
        List<String> tweets = Arrays.asList("learning RxJava", "Writing blog about RxJava", "RxJava rocks!!");
        // This is a convenient method that turns any Iterable into an
        // Observable.
        
        // Observable.just is a convenient wrapper around Observable.from.
        Observable<String> observable = Observable.from(tweets);

        observable.subscribe(new Subscriber<String>() {

            @Override
            public void onCompleted() {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void onError(Throwable e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void onNext(String t) {
                System.out.println(t);
                
            }
        });
        
        // Lambda
        //observable.subscribe(System.out::println);
    }
}
