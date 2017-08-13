package org.example.ktz.rxjava.chap5.completable;

import rx.Observable;

import java.util.concurrent.CompletableFuture;

interface TravelAgency {
	Flight search(User user, GeoLocation location);
}


class SomeTravelAgency implements TravelAgency {

	@Override
	public Flight search(User user, GeoLocation location) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new Flight();
	}
}



interface TravelAgencyAsync extends TravelAgency {
	CompletableFuture<Flight> searchAsync(User user, GeoLocation location);
}

class SomeTravelAsyncAgency extends SomeTravelAgency implements TravelAgencyAsync {

	@Override
	public CompletableFuture<Flight> searchAsync(User user, GeoLocation location) {
		return CompletableFuture.supplyAsync(() -> search(user, location));
	}
}

interface TravelAgencyRx extends TravelAgencyAsync {
	Observable<Flight> searchRx(User user, GeoLocation location);
}

class SomeTravelRxAgency extends SomeTravelAsyncAgency implements TravelAgencyRx {

	@Override
	public Observable<Flight> searchRx(User user, GeoLocation location) {
		return Util.observe(searchAsync(user, location));
	}
}