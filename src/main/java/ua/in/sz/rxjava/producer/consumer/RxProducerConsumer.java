package ua.in.sz.rxjava.producer.consumer;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Slf4j
public class RxProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        log.info("Start");

        Observable<String> observable = Observable.fromIterable(RxProducerConsumer::items)
                .subscribeOn(scheduler("subscribe-%d"))
                .observeOn(scheduler("observe-%d"));

        Disposable subscribe = observable
                .subscribe(e -> log.info("Receive: {}", e));

        while (!subscribe.isDisposed()) {
            log.info("Wait");
            Thread.sleep(10);
        }

        log.info("End");
    }

    private static Iterator<String> items() {
        return Stream.iterate(0, i -> i + 1)
                .map(i -> "Event-" + i)
                .limit(4)
                .peek(e -> log.info("Send: {}", e))
                .iterator();
    }

    private static Scheduler scheduler(String prefix) {
        BasicThreadFactory factory = new BasicThreadFactory.Builder()
                .namingPattern(prefix)
                .daemon(true)
                .build();

        return Schedulers.from(
                Executors.newFixedThreadPool(4, factory));
    }
}
