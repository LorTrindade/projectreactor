package com.projectreactor.projectreactor.sec04;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec04.helper.OrderService;
import com.projectreactor.projectreactor.sec04.helper.PurchaseOrder;
import com.projectreactor.projectreactor.sec04.helper.User;
import com.projectreactor.projectreactor.sec04.helper.UserService;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

//       Flux<PurchaseOrder> orders = UserService.getUsers()
//               .flatMap(user -> OrderService.getOrders(user.getUserId()));
//
//        Flux<PurchaseOrder> order = UserService.getUsers()
//                .flatMapIterable(user -> OrderService.getOrders(user.getUserId()).toIterable());

//        String[] purpose = {"A", "B", "C"};
//
//        Flux.fromArray(purpose)
//                .flatMap(p -> OrderService.getOrders(1))
//        .subscribe(Util.subscriber());

//        Flux.fromIterable(UserService.getUsers().toIterable())
//                .flatMap(user -> OrderService.getOrders(user.getUserId()))
//                .subscribe(Util.subscriber());
    }
}
