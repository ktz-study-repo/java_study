package org.ktz.example.rxjava;

import org.junit.Test;
import rx.Observable;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Chapter6 {
    @Test
    public void IntervalSampling() {
        long startTime = System.currentTimeMillis();
        Observable<String> intervalObservable = Observable
                .interval(7, TimeUnit.MICROSECONDS)     // 7ms 마다 이벤트가 방출
                .timestamp()
                .sample(1, TimeUnit.SECONDS)    // 7ms 마다 이벤트가 방출 되던 말던,
                                                       // 난 1초마다 마지막으로 방출된것을 갖고 갈꺼야(sampling)
                .map(ts -> ts.getTimestampMillis() - startTime + "ms: " + ts.getValue())
                .take(5);

        intervalObservable
                .subscribe(System.out::println);

        intervalObservable.toBlocking().last();
    }

    @Test
    public void DelayedSampling() {
        Observable<String> names = Observable.just(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G");

        Observable<Long> absoluteDelayMillis = Observable.just(
                0.1,
                0.6,
                0.9,    // 1초 되기 전의 마지막 값
                1.1,    // 2초 되기 전의 마지막 값
                            // 3초 되었는데 없어서 암것도 안함
                3.3,
                3.4,
                3.5,    // 4초 되기 마지막 것 왜냐하면, G 이후에 암것도 없거든요!
                3.6,
                4.4,
                4.8    // 5초가 되었지만, 암것도 없어서 출력이 음슴
        ).map(d -> (long)(d * 1_000));

        Observable<String> delayedNames = names.zipWith(absoluteDelayMillis,(n, d) ->
                Observable.just(n).delay(d, TimeUnit.MILLISECONDS))
                .flatMap(o -> o);

        delayedNames
                .throttleLast(1, TimeUnit.SECONDS)  // sample의 또 다른 별명이다.
                .subscribe(System.out::println);

        delayedNames.toBlocking().last();
    }

    @Test
    public void ThrottleFirst() {
        Observable<String> names = Observable.just(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G");

        Observable<Long> absoluteDelayMillis = Observable.just(
                0.1,    // 1초 되기 전의 마지막 값
                0.6,
                0.9,
                1.1,    // 2초 되기 전의 처음이자 마지막 값
                            // 3초 되었는데 없어서 암것도 안함
                3.3,    // 4초 되기 처음 것
                3.4,
                3.5,
                3.6,
                4.4,
                4.8    // 5초가 되었지만, 암것도 없어서 출력이 음슴
        ).map(d -> (long)(d * 1_000));

        Observable<String> delayedNames = names.zipWith(absoluteDelayMillis,(n, d) ->
                Observable.just(n).delay(d, TimeUnit.MILLISECONDS))
                .flatMap(o -> o);

        delayedNames
                .throttleFirst(1, TimeUnit.SECONDS)  // sample의 또 다른 별명이다.
                .subscribe(System.out::println);

        delayedNames.toBlocking().last();
    }

    @Test
    public void Buffering() {
        Observable
                .range(1, 7)
                .buffer(3)                  // 만약 repo에 사용한다면, 동시에 여러개를 받아서 처리할 수 있다.
                .subscribe((List<Integer> list) -> System.out.println(list));
    }

    @Test
    public void BufferingSlidingWindow() {
        Observable
                .range(1, 7)
                .buffer(3, 1)   // [1,2,3],4,5,6,7 -> 1,[2,3,4],5,6,7 이런식으로 Sliding
                .subscribe((List<Integer> list) -> System.out.println(list));
    }

    @Test
    public void BufferingOddSlidingWindow() {
        Observable
                .range(1, 7)
                .buffer(1, 2)   // [1],2,3,4,5,6,7 -> 1,2,[3],4,5,6,7 이런식으로 Sliding
                .subscribe((List<Integer> list) -> System.out.println(list));
    }

    @Test
    public void TimeBuffering() {
        Observable<String> names = Observable.just(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G");

        Observable<Long> absoluteDelayMillis = Observable.just(
                0.1,
                0.6,
                0.9,
                1.1,
                3.3,
                3.4,
                3.5,
                3.6,
                4.4,
                4.8
        ).map(d -> (long)(d * 1_000));

        Observable<String> delayedNames = names.zipWith(absoluteDelayMillis,(n, d) ->
                Observable.just(n).delay(d, TimeUnit.MILLISECONDS))
                .flatMap(o -> o);

        delayedNames
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        delayedNames.toBlocking().last();
    }

    // Buffer는 Buffer를 만들때마다 새로운 List를 생성한다.
    // 이것은 메모리 누수를 만들 수 있다.
    // 그래서 Window를 사용하보자.

    @Test
    public void TimeWindow() {
        Observable<String> names = Observable.just(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G");

        Observable<Long> absoluteDelayMillis = Observable.just(
                0.1,
                0.6,
                0.9,
                1.1,
                3.3,
                3.4,
                3.5,
                3.6,
                4.4,
                4.8
        ).map(d -> (long)(d * 1_000));

        Observable<String> delayedNames = names.zipWith(absoluteDelayMillis,(n, d) ->
                Observable.just(n).delay(d, TimeUnit.MILLISECONDS))
                .flatMap(o -> o);

        delayedNames
                .window(1, TimeUnit.SECONDS)    // 여기서 나오는 것을 Observable<Observable<String>>이다.
                                                         // 그 이유는, 버퍼를 stream형태로 받아서, 자원 낭비를 줄이기 위해!.
                .subscribe(System.out::println);

        delayedNames.toBlocking().last();
    }
}
