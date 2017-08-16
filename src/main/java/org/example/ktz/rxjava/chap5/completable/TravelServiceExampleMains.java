package org.example.ktz.rxjava.chap5.completable;

import rx.Observable;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class TravelServiceExampleMains {

    /**
     *
     * 뭐하나 할 때 마다 Block되는 Code들.
     *
     */
    static TravelService service = new TravelService();


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<TravelAgency> agencies = Collections.singletonList(new SomeTravelAgency());

        User user  = service.findById(0);   // 1초 Block
        GeoLocation location = service.locate();   // 다시 1초 Block
        ExecutorCompletionService<Flight> ecs = new ExecutorCompletionService<>(pool);

        agencies.forEach(agency ->
            ecs.submit(() -> agency.search(user, location)));   // Future니까 오케이!

        Future<Flight> firstFlight = ecs.poll(5, TimeUnit.SECONDS); // Future니까 오케이!

        Flight flight = firstFlight.get();  // 하지만 결국 다시 1초 Block
        service.book(flight);   // 다시 1초 Block
    }


    /**
     *
     * 위의 것을 CompletableFuture로 감싼다.
     * CompletableFuture는 비동기 Chain이 가능하다.
     *
     */

    static TravelAsyncService asyncService = new TravelAsyncService();

    public static void asyncMain(String[] args) throws InterruptedException, ExecutionException {

        List<TravelAgencyAsync> agencies = Collections.singletonList(new SomeTravelAsyncAgency());

        CompletableFuture<User> user = asyncService.findByIdAync(0);
        CompletableFuture<GeoLocation> location = asyncService.locateAsync();

        CompletableFuture<Ticket> ticket = user.thenCombine(location, (User us, GeoLocation loc) ->        // user와 location의 비동기 Chain
                agencies.stream()
                        .map(agency -> agency.searchAsync(us, loc))
                        .reduce((f1, f2) -> f1.applyToEither(f2, Function.identity()))
                        .get()
        )
                .thenCompose(Function.identity())       // Flatten 같은 역할을 하고 있다.
                .thenCompose(flight -> asyncService.bookAsync(flight));// 다시 비동기 체인!

        System.out.println("End of Main");

        ticket.get();

    }


    /**
     *
     * 그렇다면 이것을 다시 Rx로 비꾸어 봅시다.
     *
     */

    static TravelRxService rxService = new TravelRxService();

    public static void rxMain(String[] args) {
        Observable<TravelAgencyRx> agencies = Observable.from(Collections.singletonList(new SomeTravelRxAgency()));
        Observable<User> user = rxService.findByIdRx(0);
        Observable<GeoLocation> location = rxService.locateRx();

        Observable<Ticket> ticket = user.zipWith(location, (User us, GeoLocation loc) ->        // Completable의 Combine과 같다.
                agencies
                        .flatMap(agency -> agency.searchRx(us, loc))
                        .first()
        )
                .flatMap(x -> x)
                .flatMap(rxService::bookRx);

        System.out.println("End of Main");
        ticket.toBlocking().first();
    }
}
