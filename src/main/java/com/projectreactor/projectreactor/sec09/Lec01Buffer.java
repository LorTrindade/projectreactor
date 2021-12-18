package com.projectreactor.projectreactor.sec09;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {

    public static void main(String[] args) {

        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800)).map(i -> "Event " +i);
    }
}
