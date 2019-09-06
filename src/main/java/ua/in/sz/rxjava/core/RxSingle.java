package ua.in.sz.rxjava.core;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxSingle {
    public static void main(String[] args) {
        Single<String> single = Single.just("Hello, world!");
        single.subscribe(e -> log.info("Receive: {}", e));
    }
}
