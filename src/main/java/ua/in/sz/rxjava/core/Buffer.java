package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Buffer {
    public static void main(String[] args) {
        log.info("Start");

        Observable<List<Long>> observable = Observable
                .intervalRange(0, 7, 0, 250, TimeUnit.MILLISECONDS)
                .buffer(5);

        observable.subscribe((r) -> log.info("Receive items: {}", r.size()));

        Completable.fromObservable(observable).blockingAwait();

        log.info("End");
    }
}
