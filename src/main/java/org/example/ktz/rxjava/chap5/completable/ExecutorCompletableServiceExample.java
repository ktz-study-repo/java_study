package org.example.ktz.rxjava.chap5.completable;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class ExecutorCompletableServiceExample {
    static TravelService service = new TravelService();


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<TravelAgency> agencies = Collections.singletonList(new SomeTravelAgency());

        User user  = service.findById(0);
        GeoLocation location = service.locate();
        ExecutorCompletionService<Flight> ecs = new ExecutorCompletionService<>(pool);

        agencies.forEach(agency ->
            ecs.submit(() -> agency.search(user, location)));

        Future<Flight> firstFlight = ecs.poll(5, TimeUnit.SECONDS);

        Flight flight = firstFlight.get();
        service.book(flight);
    }


    static TravelAsyncService asyncService = new TravelAsyncService();

    public static void asyncMain(String[] args) throws InterruptedException, ExecutionException {

        List<TravelAgencyAsync> agencies = Collections.singletonList(new SomeTravelAsyncAgency());

        CompletableFuture<User> user = asyncService.findByIdAync(0);
        CompletableFuture<GeoLocation> location = asyncService.locateAsync();

        user.thenCombine(location, (User us, GeoLocation loc) ->
                agencies.stream()
                        .map(agency -> agency.searchAsync(us, loc))
                        .reduce((f1, f2) -> f1.applyToEither(f2, Function.identity()))
                        .get()
        )
                .thenCompose(Function.identity())       // Flatten 같은 역할을 하고 있다.
                .thenCompose(flight -> asyncService.bookAsync(flight));

    }
}
