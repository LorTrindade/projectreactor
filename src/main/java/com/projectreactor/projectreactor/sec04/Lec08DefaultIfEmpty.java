package com.projectreactor.projectreactor.sec04;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumber()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1, 12);
    }
}
