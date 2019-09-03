package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Delay {
    public static void main(String[] args) {
        log.info("Start");

        Disposable disposable = Observable.just(1, 2, 4)
                .delay(5, TimeUnit.SECONDS)
                .subscribe((i) -> log.info("Receive: {}", i));

        WaitUtils.wait(disposable);

        log.info("End");
    }
}
