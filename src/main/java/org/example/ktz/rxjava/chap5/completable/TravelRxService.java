package org.example.ktz.rxjava.chap5.completable;

import rx.Observable;

public class TravelRxService extends TravelAsyncService{

    /**
     *
     * 이제 CompletableFuture를 Rx로 감싸보자.
     *
     */


    public Observable<User> findByIdRx(long userId) {
        return Util.observe(findByIdAync(userId));
    }

    public Observable<GeoLocation> locateRx() {
        return Util.observe(locateAsync());
    }

    public Observable<Ticket> bookRx(Flight flight) {
        return Util.observe(bookAsync(flight));
    }
}
