package org.ktz.example.rxjava;

import io.reactivex.Observable;
import org.junit.Test;

/**
 * Created by ktz on 2017. 7. 12..
 */
public class Chapter3 {

    @Test
    public void filterTest() {
        Observable<Integer> ints = Observable.range(1, 10);

        Observable<Integer> evens = ints.filter(i -> i % 2 == 0);

        Observable<Integer> addOne = evens.map(i -> i + 1);

        Observable<Integer> addTwo = addOne.flatMap(i -> Observable.just(i + 1));

        addTwo.subscribe(System.out::println);
    }

    @Test
    public void ObserverbleFlow() {
        Observable
                .just(8, 9, 10)
                .doOnNext(i -> System.out.println("A: " + i))
                .filter(i -> i % 3 > 0)
                .doOnNext(i -> System.out.println("B: " + i))
                .map(i -> "#" + i * 10)
                .doOnNext(s -> System.out.println("C: " + s))
                .filter(s -> s.length() < 4)
                .subscribe(s -> System.out.println("D: " + s));
    }
}
