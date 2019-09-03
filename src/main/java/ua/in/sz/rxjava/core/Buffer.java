package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Buffer {
    public static void main(String[] args) {
        log.info("Start");

        WaitUtils.wait(
                Observable
                        .intervalRange(0, 7, 0, 250, TimeUnit.MILLISECONDS)
                        .buffer(5)
                        .subscribe((r) -> log.info("Receive: {}", r.size()))
        );

        log.info("End");
    }
}
