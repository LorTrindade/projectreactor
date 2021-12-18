package com.projectreactor.projectreactor.sec09;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Group {

    public static void main(String[] args) {

        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2)
                .subscribe(gf -> process(gf, gf.key()));

        Util.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key) {
        flux.subscribe(i -> System.out.println("Key: " + key + ", Item: " + i));
    }
}
