package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Timeout {
    public static void main(String[] args) {
        WaitUtils.wait(
                Observable.interval(1, TimeUnit.SECONDS)
                        .timeout(500, TimeUnit.MILLISECONDS)
                        .subscribe(
                                (e) -> log.info("Receive: {}", e),
                                (t) -> log.warn("Timeout: {}", t.getMessage()))
        );
    }
}
