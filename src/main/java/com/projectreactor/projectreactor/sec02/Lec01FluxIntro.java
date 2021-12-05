package com.projectreactor.projectreactor.sec02;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().fullName());
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
