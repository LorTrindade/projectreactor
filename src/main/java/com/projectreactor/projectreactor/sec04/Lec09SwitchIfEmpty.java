package com.projectreactor.projectreactor.sec04;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {

        getOrderNumber()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback()) // se o valor do filter retornar vazio, ele chama a callback
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1, 11);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
