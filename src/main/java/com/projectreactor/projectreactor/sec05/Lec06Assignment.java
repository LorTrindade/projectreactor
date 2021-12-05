package com.projectreactor.projectreactor.sec05;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec05.assignment.InventoryService;
import com.projectreactor.projectreactor.sec05.assignment.OrderService;
import com.projectreactor.projectreactor.sec05.assignment.RevenueService;

public class Lec06Assignment {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inventory - observe the order stream
        orderService.getOrderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.getOrderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
