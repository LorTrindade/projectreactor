package com.projectreactor.projectreactor.sec03;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting: " + country);
            synchronousSink.next(country);
            counter.incrementAndGet();
            if (country.toLowerCase().equals("canada") ) {
                synchronousSink.complete();
            }
        })
                .subscribe(Util.subscriber());
    }
}
