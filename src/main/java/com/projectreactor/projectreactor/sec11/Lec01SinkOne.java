package com.projectreactor.projectreactor.sec11;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

    public static void main(String[] args) {

        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));

        sink.tryEmitValue("hello");

    }
}
