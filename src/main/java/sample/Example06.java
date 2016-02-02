package sample;

import rx.Observable;

public class Example06 {

    public static void main(String[] args) {

        // map
        Observable<String> mapObservable = Observable.just("learning RxJava", "Writing blog about RxJava",
                "RxJava rocks!!");
        mapObservable.map(x -> x.length()).subscribe(s -> System.out.println(s));

        // filter
        Observable<String> filterObservable = Observable.just("learning RxJava", "Writing blog about RxJava",
                "RxJava rocks!!");
        filterObservable.filter(tweet -> tweet.startsWith("RxJava")).subscribe(s -> System.out.println(s));
        
        // Aggregation 
        Observable<String> countObservable = Observable.just("learning RxJava", "Writing blog about RxJava",
                "RxJava rocks!!");
        countObservable.count().subscribe(s -> System.out.println(s));
     
        Observable<String> groupObservable = Observable.just("Tom", "Tom", "John", "Gray", "John", "Mary");
        
        groupObservable.groupBy(n-> n).flatMap(g -> {
            return g.reduce((s, s2) -> s + s2);
        }).subscribe(System.out::println);
        
      
    }

}
