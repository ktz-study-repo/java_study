package org.example.ktz.rxjava.chap5.completable;

import java.util.Collections;
import java.util.Map;

public class TravelService {
    Map<Long, User> users = Collections.emptyMap();

    public User findById(long userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new User();
    }

    GeoLocation locate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new GeoLocation();
    }

    Ticket book(Flight flight)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Ticket();
    }
}
