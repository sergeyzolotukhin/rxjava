package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class PublishSubjectMain {

    public static void main(String[] args) {
        publishToManySubscribes();
    }

    private static void publishToManySubscribes() {
        log.info("Start");

        Observable<Long> range1 = Observable.intervalRange(0, 4, 100, 300, TimeUnit.MILLISECONDS);

        io.reactivex.subjects.PublishSubject<Object> subject = io.reactivex.subjects.PublishSubject.create();

        Disposable disposable1 = subject.subscribe((e) -> log.info("Receive 1: {}", e));
        Disposable disposable2 = subject.subscribe((e) -> log.info("Receive 2: {}", e));
        Disposable disposable3 = subject.subscribe((e) -> log.info("Receive 3: {}", e));

        range1.subscribe(subject);

        WaitUtils.wait(disposable1, disposable2, disposable3);

        log.info("Source subscribe");
    }

    private static void subjectSubscribesOnTwoRange() {
        log.info("Start");

        Observable<Long> range1 = Observable.intervalRange(0, 4, 100, 300, TimeUnit.MILLISECONDS);
        Observable<Long> range2 = Observable.intervalRange(16, 4, 100, 250, TimeUnit.MILLISECONDS);

        io.reactivex.subjects.PublishSubject<Object> subject = io.reactivex.subjects.PublishSubject.create();

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
