package com.projectreactor.projectreactor.sec02;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
//        Mono<String> mono = Mono.just("a");
//        Flux<String> flux = Flux.from(mono);
//        flux.subscribe(Util.onNext());
//        doSomething(flux);

        Flux.range(1, 10)
                .next()
                .filter(f -> f > 1)
                .subscribe(Util.onNext());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
