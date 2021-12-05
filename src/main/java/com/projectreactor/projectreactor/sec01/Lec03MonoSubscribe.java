package com.projectreactor.projectreactor.sec01;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

import static com.projectreactor.projectreactor.courseutil.Util.onNext;
import static com.projectreactor.projectreactor.courseutil.Util.onError;
import static com.projectreactor.projectreactor.courseutil.Util.onComplete;


public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        //publisher
//        Mono<String> mono = Mono.just("ball");

        //publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        //1
//        mono.subscribe();


//        //2
//        mono.subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println(err),
//                () -> System.out.println("Completed")
//        );

//        //2
//        mono.subscribe(
//                e -> { just(); },
//                onError(),
//                onComplete()
//                );

        //2
        Disposable subscribe = mono.subscribe(
                e -> {
                    just();
                },
                onError()
        );

//        mono.doOnSubscribe(s -> just());
    }

    public static Mono just() {
        Mono<String> just = Mono.just("Ola!");
        just.subscribe(System.out::println);
        return just;
    }
}
