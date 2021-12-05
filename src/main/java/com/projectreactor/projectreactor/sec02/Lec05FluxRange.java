package com.projectreactor.projectreactor.sec02;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lec05FluxRange {

    public static void main(String[] args) {

//        Flux.range(3, 10)
//                .log()
//                .map(i -> Util.faker().name().fullName())
//                .log()
//                .subscribe(
//                        Util.onNext()
//                );


        Flux.range(3, 5)
                .map(i -> i / (i - 4))
        .subscribe(Util.onNext());

        List<List<Integer>> listOfListofInts = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList( 7, 8, 9));
        System.out.println("Flatmap: " + listOfListofInts.stream().flatMap(List::stream).collect(Collectors.toList()));
        System.out.println("Map: " + listOfListofInts.stream().map(List::stream).collect(Collectors.toList()));


    }
}
