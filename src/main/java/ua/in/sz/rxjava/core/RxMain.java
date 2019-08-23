package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class RxMain {
    public static void main(String[] args) {
        Observable<String> observable = Observable.fromIterable(RxMain::events)
                .filter(e -> e.getNo() % 2 == 0)
                .map(EventDto::getName);

        Disposable subscribe = observable
                .subscribe(e -> log.info("Receive: {}", e));
    }

    private static Iterator<EventDto> events() {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> EventDto.of("Event-" + i, i))
                .limit(10)
                .peek(e -> log.info("Send: {}", e.getName()))
                .iterator();
    }

}
