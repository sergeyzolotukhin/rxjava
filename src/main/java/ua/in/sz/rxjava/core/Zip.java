package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class Zip {
    public static void main(String[] args) {
        Observable<String> observable = Observable.zip(
                Observable.fromIterable(() -> human("man", 2)),
                Observable.fromIterable(() -> human("woman", 5)),
                (m, w) -> m + " + " + w);

        observable.subscribe(i -> log.info("Receive {}", i));
    }

    private static Iterator<String> human(String prefix, int limit) {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> prefix + "-" + i)
                .limit(limit)
                .iterator();
    }
}
