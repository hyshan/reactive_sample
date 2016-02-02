package sample;

import java.util.ArrayList;

import rx.Observable;

public class Example09 {

    public static void main(String[] args) {
        // count
        Observable<Integer> range = Observable.range(0, 10);

        range.count().subscribe(s -> System.out.println("count " + s));
        
        // first
        range.first(v -> v > 5).subscribe(s -> System.out.println("first " + s));
        range.first(v -> v > 11).subscribe(s -> System.out.println(s), 
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed"));
        range.firstOrDefault(0, v -> v > 11).subscribe(s -> System.out.println("first " + s), 
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed"));

        // single
        range.single(v -> v==5).subscribe(s -> System.out.println("single " + s));
        
        range.single(v -> v>5).subscribe(s -> System.out.println(s), 
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed"));
        
        // reduce
        range.reduce((i1, i2) -> i1 + i2).subscribe(s -> System.out.println("reduce " + s));
        
        range.reduce(0, (acc,next) -> acc + 1).subscribe(s -> System.out.println("reduce " + s));
        
        // scan 
        range.scan((i1, i2) -> i1 + i2).subscribe(s -> System.out.println("scan " + s));
        
        // collect
        range.collect(
            () -> new ArrayList<Integer>(),
            (acc, value) -> acc.add(value))
        .subscribe(s -> System.out.println(s));
        
        // toList
        range.toList().subscribe(s -> System.out.println(s));
        
        // groupBy
        
        Observable<String> values = Observable.just("John", "Mary", "Harry", "Harry", "Harry", "John", "Mary", "Mary",
                "Mary");
        
        values.groupBy(v -> v)
                .subscribe(group -> group.count().subscribe(v -> System.out.println(group.getKey() + ": " + v)));
        
    }

}
