package com.projectreactor.projectreactor.sec08;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {

    public static void main(String[] args) {

        Flux.zip(getBody(), getTires(), getEngine())
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(i -> "body");
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "tires");
    }
}
