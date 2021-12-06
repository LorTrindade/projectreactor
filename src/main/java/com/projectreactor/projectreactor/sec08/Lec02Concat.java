package com.projectreactor.projectreactor.sec08;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {

    public static void main(String[] args) {

        Flux<String> flux = Flux.just("a", "b");
        Flux<String> fluxOne = Flux.just("c", "d", "e");
        Flux<String> fluxTwo = Flux.error(new RuntimeException("oops"));

//        Flux<String> fluxConcat = flux.concatWith(fluxOne);
//        Flux<String> fluxConcat = Flux.concat(flux, fluxOne, fluxTwo);
        Flux<String> fluxConcat = Flux.concatDelayError(flux, fluxOne, fluxTwo);
        fluxConcat.subscribe(Util.subscriber());

    }
}
