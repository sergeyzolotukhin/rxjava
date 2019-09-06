package ua.in.sz.rxjava.core;

import io.reactivex.Maybe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxMaybe {
    public static void main(String[] args) {
        Maybe.empty().subscribe((m) -> log.info("onSuccess: {}", m));
        Maybe.just("hello").subscribe((m) -> log.info("onSuccess: {}", m));

        Maybe.empty()
                .subscribe(
                        (m) -> log.info("onSuccess: {}", m),
                        (e) -> log.error("onError:", e),
                        () -> log.info("onComplete")
                );

        Maybe.just("hello")
                .subscribe(
                        (m) -> log.info("onSuccess: {}", m),
                        (e) -> log.error("onError:", e),
                        () -> log.info("onComplete")
                );
    }
}
