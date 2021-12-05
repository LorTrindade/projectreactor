package com.projectreactor.projectreactor.sec03;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec03FluxTake {

    public static void main(String[] args) {


        Flux.range(1, 10)
                .log()
                .take(5) //after get the number of values provided, it cancels the upstream
                .log()
                .subscribe(Util.subscriber());

//        Flux.range(1, 10)
//                .takeLast(5)
//                .subscribe(Util.subscriber());
    }
}
