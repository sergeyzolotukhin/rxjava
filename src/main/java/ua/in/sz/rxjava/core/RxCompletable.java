package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RxCompletable {
    public static void main(String[] args) {
        log.info("Start");

        Observable<Long> observable = Observable.intervalRange(
                0, 10, 0, 500, TimeUnit.MILLISECONDS);

        observable.subscribe((i) -> log.info("Receive: {}", i));
        Completable.fromObservable(observable).blockingAwait();

        log.info("End");
    }
}
