package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RxUsing {
    public static void main(String[] args) {
        log.info("Start");

        WaitUtils.wait(
                Observable.using(
                        RxUsing::openResource,
                        RxUsing::intervalRange,
                        RxUsing::closeResource
                ).subscribe((e) -> log.info("Receive: {}", e))
        );

        log.info("End");
    }

    private static ObservableSource<Long> intervalRange(@NonNull String resource) throws Exception {
        return Observable.intervalRange(0, 4, 0, 1, TimeUnit.SECONDS);
    }

    private static String openResource() {
        String resource = "Resource 1";
        log.info("Open {}", resource);
        return resource;
    }

    private static void closeResource(String resource) {
        log.info("Close {}", resource);
    }
}
