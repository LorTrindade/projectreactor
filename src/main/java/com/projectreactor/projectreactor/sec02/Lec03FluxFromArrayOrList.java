package com.projectreactor.projectreactor.sec02;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {

//        List<String> strings = Arrays.asList("a", "b", "c");

        Integer[] arr = {2, 5, 7, 8};
        Integer sorted = Arrays.stream(arr).max(Integer::compareTo).get() - 1;
        System.out.println(sorted);
//        Flux.fromArray(arr)
//                .subscribe(Util.onNext());
//        Flux.fromIterable(strings)
//                .subscribe(Util.onNext());
    }
}
