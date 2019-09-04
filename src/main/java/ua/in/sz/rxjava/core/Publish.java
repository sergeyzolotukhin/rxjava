package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Publish {
    public static void main(String[] args) {
        ConnectableObservable<Long> observable = Observable.intervalRange(
                0, 4, 100, 300, TimeUnit.MILLISECONDS)
                .publish();

        observable.subscribe(e -> log.info("Receive 1: {}", e));
        observable.subscribe(e -> log.info("Receive 2: {}", e));

        log.info("Subscribed");

        observable.connect();

        Completable.fromObservable(observable).blockingAwait();

        log.info("End");
    }
}
