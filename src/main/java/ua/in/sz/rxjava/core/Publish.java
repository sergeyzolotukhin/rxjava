package ua.in.sz.rxjava.core;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Slf4j
public class Publish {
    public static void main(String[] args) {
        ConnectableObservable<String> observable = Observable.fromIterable(Publish::items).publish();

//        Observable<String> observable1 = observable.subscribeOn(scheduler("subscribe-%d"));
//        Observable<String> observable2 = observable.observeOn(scheduler("observe-%d"));

        Disposable disposable1 = observable.subscribe(e -> log.info("Receive 1: {}", e));
        Disposable disposable2 = observable.subscribe(e -> log.info("Receive 2: {}", e));

//        Flowable<String> flowable = observable.toFlowable(BackpressureStrategy.MISSING);

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

    private static Scheduler scheduler(String prefix) {
        BasicThreadFactory factory = new BasicThreadFactory.Builder()
                .namingPattern(prefix)
                .daemon(true)
                .build();

        return Schedulers.from(
                Executors.newFixedThreadPool(4, factory));
    }
}
