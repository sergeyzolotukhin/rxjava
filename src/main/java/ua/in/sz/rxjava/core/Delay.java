package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Delay {
    public static void main(String[] args) {
        log.info("Start");

        Observable<Integer> observable = Observable.just(1, 2, 4)
                .delay(2, TimeUnit.SECONDS);

        observable.subscribe((i) -> log.info("Receive: {}", i));

        Completable.fromObservable(observable).blockingAwait();

        log.info("End");
    }
}
