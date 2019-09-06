package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import ua.in.sz.rxjava.core.impl.EventDto;

import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public class ErrorHandling {
    public static void main(String[] args) {
        Observable<String> observable = Observable.fromIterable(ErrorHandling::events)
                .filter(e -> e.getNo() % 2 == 0)
                .map(EventDto::getName);

        observable.subscribe(
                        e -> log.info("Receive: {}", e),
                        e -> log.error("Error", e));
    }

    private static Iterator<EventDto> events() {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> EventDto.of("Event-" + i, i))
                .limit(2)
                .peek(e -> log.info("Send: {}", e.getName()))
                .peek(e -> {
                    if (e.getNo() >= 1) throw new RuntimeException(e.getName());
                })
                .iterator();
    }

}
