package com.example.creatshop.job.state;

import com.example.creatshop.constant.OrderStatus;

/**
 * ----------------------------------------------------------------------------
 * Author:        Hong Anh
 * Created on:    14/12/2024 at 11:19 PM
 * Project:       CreaTShop-server
 * Contact:       https://github.com/lehonganh0201
 * ----------------------------------------------------------------------------
 */

public abstract class OrderState {

    // Phương thức chuyển từ OrderStatus sang OrderState
    public static OrderState from(OrderStatus status) {
        switch (status) {
            case Processing:
                return new ProcessingState();
            case Shipped:
                return new ShippedState();
            case Delivered:
                return new DeliveredState();
            default:
                throw new IllegalArgumentException("Unknown order status: " + status);
        }
    }

    public abstract void next(OrderContext context);

    public abstract void prev(OrderContext context);

    public abstract OrderStatus getStatus(); // Trả về OrderStatus của trạng thái hiện tại
}
