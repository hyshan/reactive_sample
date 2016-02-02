package sample;

import rx.Observable;
import rx.Observer;

public class Example01 {

    public static void main(String[] args) {
        // just is one of the many factory methods that can be used to produce
        // an Observable
        Observable<String> tweets = Observable.just("learning RxJava", "Writing blog about RxJava", "RxJava rocks!!");
        
        // an Observer/Subscriber is subscribed to the Observable by calling the subscribe
        tweets.subscribe(new Observer<String>() {
            
            // This method notifies the Observer that no more events will be
            // pushed by the Observable.
            @Override
            public void onCompleted() {

            }

            // This method notifies the Observer that the Observable has
            // experienced an error condition.
            @Override
            public void onError(Throwable e) {

            }
            
            // This method on Observer is invoked whenever Observable has a new
            // item.
            @Override
            public void onNext(String t) {
                System.out.println(t);

            }
        });

        // Lambda
        // The tweet -> System.out.println(tweet) is a lambda expression of type
        // Action1<String> which will print to the console whenever a new event
        // is received. 
        // tweets.subscribe(tweet -> System.out.println(tweet));
        
        /*tweets.subscribe((tweet) -> System.out.println(tweet),
                (error) -> System.out.println("Something went wrong" + ((Throwable) error).getMessage()),
                () -> System.out.println("This observable is finished"));*/
    }

}
