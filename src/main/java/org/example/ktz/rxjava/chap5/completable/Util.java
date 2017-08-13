package org.example.ktz.rxjava.chap5.completable;

import rx.Observable;

import java.util.concurrent.CompletableFuture;

public class Util {
    static <T> Observable<T> observe(CompletableFuture<T> future) {
        return Observable.create(subscriber -> {
            future.whenComplete((value, exception) -> {
                if(exception != null)
                    subscriber.onError(exception);
                else {
                    subscriber.onNext(value);
                    subscriber.onCompleted();
                }
            });
        });
    }
}
