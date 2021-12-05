package com.projectreactor.projectreactor.sec02;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
        NameGenerator.getNames(3).subscribe(Util.onNext());
    }
}
