package com.projectreactor.projectreactor.sec04;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {

        //handle = filter + map

        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer % 2 == 0)
                        synchronousSink.next(integer); //filter
                    else
                        synchronousSink.next(integer + "a"); //map
                })
                .subscribe(Util.subscriber());
    }

}
