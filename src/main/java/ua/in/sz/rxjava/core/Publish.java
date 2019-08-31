package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class Publish {
    public static void main(String[] args) {
        ConnectableObservable<String> observable = Observable.fromIterable(Publish::items).publish();

        Disposable disposable1 = observable.subscribe(e -> log.info("Receive 1: {}", e));
        Disposable disposable2 = observable.subscribe(e -> log.info("Receive 2: {}", e));

        log.info("Subscribed");

        observable.connect();

        log.info("End");
    }

    private static Iterator<String> items() {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> "Event-" + i)
                .limit(4)
                .peek(e -> log.info("Send: {}", e))
                .iterator();
    }
}
