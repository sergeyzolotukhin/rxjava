package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Publish {
    public static void main(String[] args) {
        ConnectableObservable<Long> observable = Observable.intervalRange(
                0, 4, 100, 300, TimeUnit.MILLISECONDS)
                .publish();

        Disposable disposable1 = observable.subscribe(e -> log.info("Receive 1: {}", e));
        Disposable disposable2 = observable.subscribe(e -> log.info("Receive 2: {}", e));

        log.info("Subscribed");

        observable.connect();

        WaitUtils.wait(disposable1, disposable2);

        log.info("End");
    }
}
