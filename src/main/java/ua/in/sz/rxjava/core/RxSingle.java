package ua.in.sz.rxjava.core;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxSingle {
    public static void main(String[] args) {
        log.info("Start");

        Single<String> single = Single.just("Hello, world!");
        single.subscribe(e -> log.info("Receive: {}", e));

        log.info("Before fetch");

        Single<String> fetch = fetch();

        log.info("After fetch");

        fetch.subscribe(m -> log.info("Receive: {}", m));

        log.info("End");
    }

    private static Single<String> fetch() {
        return Single.create(subscriber -> subscriber.onSuccess("Completed"));
    }
}
