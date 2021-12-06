package com.projectreactor.projectreactor.sec08;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec08.helper.AmericanAirlinesFlights;
import com.projectreactor.projectreactor.sec08.helper.EmiratesFlights;
import com.projectreactor.projectreactor.sec08.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                QatarFlights.getFlights(),
                EmiratesFlights.getFlights(),
                AmericanAirlinesFlights.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
