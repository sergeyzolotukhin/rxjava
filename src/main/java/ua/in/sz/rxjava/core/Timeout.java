package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Timeout {
    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .timeout(500, TimeUnit.MILLISECONDS);

        observable.subscribe(
                        (e) -> log.info("Receive: {}", e),
                        (t) -> log.warn("Timeout: {}", t.getMessage()));

        Completable.fromObservable(observable).blockingAwait();
    }
}
