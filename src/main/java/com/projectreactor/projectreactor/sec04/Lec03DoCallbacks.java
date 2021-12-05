package com.projectreactor.projectreactor.sec04;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            //fluxSink.complete();
            fluxSink.error(new RuntimeException("ooops!"));
            System.out.println("--completed");
        })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext: " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
                .doOnRequest(l -> System.out.println("doOnRequest: " + l))
                .doFirst(() -> System.out.println("doOnFirst 2"))
                .doOnError(err -> System.out.println("doOnError: " + err))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally(signal -> System.out.println("doOnFinally: " + signal))
                .doFirst(() -> System.out.println("doOnFirst 3"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
                .subscribe(Util.subscriber());

    }
}
