package org.ktz.example.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter4 {
    class Person {
        final public Integer index;

        Person(Integer index) {
            this.index = index;
        }
    }

    class PersonDao {
        Observable<Person> listPeople() {
            Observable<Person> peopleStream = Observable.fromIterable(query(""));
            Single<List<Person>> peopleList = peopleStream.toList();
            List<Person> people = peopleList.blockingGet();
            return Observable.fromIterable(query(""));
        }

        public Observable<Person> listPeople2() {
            return Observable.defer(() -> Observable.fromIterable(query("")));
        }
    }

    private List<Person> query(String sql) {
        return Arrays.asList(1,2,3,4,5,6,7).stream().map(Person::new).collect(Collectors.toList());
    }
}
