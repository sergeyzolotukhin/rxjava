package ua.in.sz.rxjava.core;

import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
final class WaitUtils {

    private WaitUtils() {
        // No instance
    }

    static void wait(Disposable disposable) {
        while (!disposable.isDisposed()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("Interrupted", e);
            }
        }
    }
}
