package sample;

import rx.Observable;

public class Example10 {

    public static void main(String[] args) {
        
        // map
        Observable<String> names = Observable.just("mary", "john", "harry");
        
        names.map(v -> Character.toUpperCase(v.charAt(0)) + v.substring(1)).subscribe(s -> System.out.println(s));
        
        Observable<Integer> values = Observable.just(2);

        values.map(i -> Observable.range(0, i)).subscribe(s -> System.out.println(s));
        
        values.flatMap(i -> Observable.range(0, i)).subscribe(s -> System.out.println(s));
        
    }

}
