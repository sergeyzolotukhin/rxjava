package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class Merge {
    public static void main(String[] args) {
        Observable<String> alphabet = Observable.just("A", "B", "C", "D");
        Observable<String> numbers = Observable.fromIterable(Merge::events);

        Observable<String> observable = Observable.merge(alphabet, numbers);

        Disposable subscribe = observable.subscribe(e -> log.info("Receive: {}", e));
    }

    private static Iterator<String> events() {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> "#" + i)
                .limit(2)
                .iterator();
    }
}
