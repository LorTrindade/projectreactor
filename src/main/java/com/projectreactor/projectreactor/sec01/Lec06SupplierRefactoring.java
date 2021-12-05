package com.projectreactor.projectreactor.sec01;

import com.projectreactor.projectreactor.courseutil.Util;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName("1");
//        getName("2")
//                .subscribeOn(Schedulers.boundedElastic())
//                .block();
        getName("2")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        getName("3");

        getName("Teste").subscribe(
                value -> getNameNoMono(value),
                error -> error.printStackTrace()
        );


        Util.sleepSeconds(4);
        System.out.println("oooooooooo: " + testDois());
    }

    public static String test() {
        return String.valueOf(getName("4").map(value -> {
            return value;
        }).subscribe(s -> getNameNoMono(s)));
    }

    public static String testDois() {
       var idontknow = getName("4").subscribe(s -> getNameNoMono(s));

       return idontknow.toString();

    }

    private static Mono<String> getName(String text) {
        System.out.println("entered getName method " + text);
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase).as(Mono::from);
    }

    private static String getNameNoMono(String text) {
        System.out.println("Olha o retorno do mono passando aqui: " + text);
        return text;
    }
}
