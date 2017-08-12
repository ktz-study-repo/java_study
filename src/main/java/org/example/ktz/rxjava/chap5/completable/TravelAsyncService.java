package org.example.ktz.rxjava.chap5.completable;

import java.util.concurrent.CompletableFuture;

public class TravelAsyncService extends TravelService{
    public CompletableFuture<User> findByIdAync(long userId) {
        return CompletableFuture.supplyAsync(() -> findById(userId));
    }

    public CompletableFuture<GeoLocation> locateAsync() {
        return CompletableFuture.supplyAsync(this::locate);
    }

    public CompletableFuture<Ticket> bookAsync(Flight flight) {
        return CompletableFuture.supplyAsync(() -> book(flight));
    }

}
