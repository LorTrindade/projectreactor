package com.projectreactor.projectreactor.sec06;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        })
                .map(i -> i + "a")
                .publishOn(Schedulers.boundedElastic())
                .subscribeOn(Schedulers.parallel())
                .subscribe(Util.subscriber());

//        Flux.interval(Duration.ofSeconds(1))
//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe(Util.subscriber());
//
//        Util.sleepSeconds(60);
    }
}
