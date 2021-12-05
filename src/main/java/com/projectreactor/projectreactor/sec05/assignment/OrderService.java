package com.projectreactor.projectreactor.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

import static java.util.Objects.isNull;

public class OrderService {

    private Flux<PurchaseOrder> flux;

    private Flux<PurchaseOrder> orderStream() {
        if (isNull(flux))
            flux=getOrderStream();
        return flux;
    }

    public Flux<PurchaseOrder> getOrderStream() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder())
                .publish()
                .refCount(2);
    }
}
