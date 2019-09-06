package ua.in.sz.rxjava.core;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lift {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .lift(new EvenOperator())
                .subscribe(e -> log.info("Receive: {}", e));
    }

    private static final class EvenOperator
            implements ObservableOperator<Integer, Integer> {

        @Override
        public Observer<? super Integer> apply(Observer<? super Integer> downstream) {
            return new EvenObserver<>(downstream);
        }
    }

    private static final class EvenObserver<T extends Integer>
            implements Observer<T>, Disposable {

        final Observer<? super Integer> downstream;
        Disposable upstream;

        EvenObserver(Observer<? super Integer> downstream) {
            this.downstream = downstream;
        }

        @Override
        public void onSubscribe(Disposable d) {
            if (upstream != null) {
                d.dispose();
            } else {
                upstream = d;
                downstream.onSubscribe(this);
            }
        }

        @Override
        public void onNext(T item) {
            if (item.intValue() % 2 == 0) {
                downstream.onNext(item);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            downstream.onError(throwable);
        }

        @Override
        public void onComplete() {
            downstream.onComplete();
        }

        @Override
        public void dispose() {
            upstream.dispose();
        }

        @Override
        public boolean isDisposed() {
            return upstream.isDisposed();
        }
    }
}
