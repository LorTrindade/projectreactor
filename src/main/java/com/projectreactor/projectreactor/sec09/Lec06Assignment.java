package com.projectreactor.projectreactor.sec09;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec09.assignment.OrderProcess;
import com.projectreactor.projectreactor.sec09.assignment.OrderService;
import com.projectreactor.projectreactor.sec09.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {

    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Kids", OrderProcess.kidsProcessing(),
                "Automotive", OrderProcess.automativeProcessing()
        );

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
