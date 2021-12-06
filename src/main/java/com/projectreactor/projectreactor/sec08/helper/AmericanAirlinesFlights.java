package com.projectreactor.projectreactor.sec08.helper;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericanAirlinesFlights {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "American Airlines " + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
