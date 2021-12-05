package com.projectreactor.projectreactor.sec03;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                synchronousSink.next(Util.faker().country().name());
//            synchronousSink.error(new RuntimeException("ops"));
        })
                .subscribe(Util.subscriber());
    }
}
