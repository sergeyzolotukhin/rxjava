package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RxPublishSubject {

    public static void main(String[] args) {
        log.info("Start");

        Observable<Long> range1 = Observable.intervalRange(0, 4, 100, 300, TimeUnit.MILLISECONDS);
        Observable<Long> range2 = Observable.intervalRange(16, 4, 100, 250, TimeUnit.MILLISECONDS);

        PublishSubject<Object> subject = PublishSubject.create();

        log.info("Source subscribe");

        range2.subscribe(subject);
        range1.subscribe(subject);

        Disposable disposable = subject.subscribe((e) -> log.info("Receive: {}", e));
        WaitUtils.wait(disposable);

        log.info("End");
    }
/*
Observable.fromIterable();
Observable.fromPublisher();
Observable.fromCallable();
Observable.fromArray();
Observable.fromFuture();

Observable.just();
Observable.generate();
Observable.create();
Observable.defer();
Observable.interval();
Observable.range();

Observable.timer();
Observable.using();// ?
Observable.sequenceEqual(); //
Observable.amb(); //?
*/

}
