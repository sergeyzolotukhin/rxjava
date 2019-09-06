package ua.in.sz.rxjava.core;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rx2Completable {
    public static void main(String[] args) {
        Completable completable = Completable.create(CompletableEmitter::onComplete);

        completable.subscribe(() -> log.info("onComplete"));
    }
}
