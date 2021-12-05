package com.projectreactor.projectreactor.sec03;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {


    public static void main(String[] args) {
        Flux.create(synchronousSink -> {

            synchronousSink.next(1);
            synchronousSink.next(2);

        })
                .subscribe(System.out::println);
//        Flux.create(fluxSink -> {
//            String country;
//            do {
//                country = Util.faker().country().name();
//                fluxSink.next(country);
//            }
//            while (!country.toLowerCase().equals("canada"));
//            fluxSink.complete();
//        }).subscribe(Util.subscriber());
    }
}
