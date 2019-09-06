package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class FlatMap {
    public static void main(String[] args) {
        Observable<String> observable = Observable.fromIterable(FlatMap::numbers)
                .flatMap(FlatMap::children);

        observable.subscribe(i -> log.info("Receive {}", i));
    }

    private static ObservableSource<String> children(String p) {
        return Observable.just("" + p + "-1", "" + p + "-2");
    }

    private static Iterator<String> numbers() {
        return Stream.iterate(0, i -> i + 1)
                .limit(10)
                .map(i -> "" + i)
                .iterator();
    }
}
