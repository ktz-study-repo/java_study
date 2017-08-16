package org.example.ktz.rxjava.chap5.completable;

import rx.Observable;

import java.util.concurrent.CompletableFuture;

public class Util {
    static <T> Observable<T> observe(CompletableFuture<T> future) {
        return Observable.create(subscriber -> {        // Callback을 Obervable로 만들어보자.
            future.whenComplete((value, exception) -> {
                if(exception != null)                   //  만약 Error가 났을 경우
                    subscriber.onError(exception);
                else                                    // 만약 성공했을 경우
                    subscriber.onNext(value);
                    subscriber.onCompleted();
                });
        });
    }
}
