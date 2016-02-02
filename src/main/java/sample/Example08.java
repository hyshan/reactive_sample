package sample;

import rx.Observable;

public class Example08 {

    public static void main(String[] args) {
        
        // filter
        Observable<Integer> filter = Observable.range(0, 10).filter(v -> v % 2 == 0);
        filter.subscribe(v -> System.out.println(v), 
                         e -> System.out.println("Error: " + e),
                         () -> System.out.println("Completed"));
        
        // distinct 
        
        Observable<Integer> distinct = Observable.create(o -> {
            o.onNext(1);
            o.onNext(1);
            o.onNext(2);
            o.onNext(3);
            o.onNext(2);
            o.onNext(2);
            o.onNext(3);
            o.onCompleted();
        });

        distinct.distinct().subscribe(v -> System.out.println(v), 
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed"));
        
        // distinct until change
        
        distinct.distinctUntilChanged().subscribe(v -> System.out.println(v), 
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed"));
        
        // distinct with key selector
        Observable<String> values = Observable.create(o -> {
            o.onNext("First");
            o.onNext("Second");
            o.onNext("Third");
            o.onNext("Fourth");
            o.onNext("Fifth");
            o.onCompleted();
        });
        
        values.distinct(v -> v.charAt(0)).subscribe(v -> System.out.println(v), 
              e -> System.out.println("Error: " + e),
              () -> System.out.println("Completed"));
        
        // take
        Observable<Integer> take = Observable.range(0, 5);

        take.take(2).subscribe(v -> System.out.println(v), 
                               e -> System.out.println("Error: " + e),
                              () -> System.out.println("Completed"));
        // skip
        take.skip(2).subscribe(v -> System.out.println(v), 
                               e -> System.out.println("Error: " + e),
                               () -> System.out.println("Completed"));
    }

}
