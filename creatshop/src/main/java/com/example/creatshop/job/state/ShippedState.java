package com.example.creatshop.job.state;

import com.example.creatshop.constant.OrderStatus;

/**
 * ----------------------------------------------------------------------------
 * Author:        Hong Anh
 * Created on:    14/12/2024 at 11:20 PM
 * Project:       CreaTShop-server
 * Contact:       https://github.com/lehonganh0201
 * ----------------------------------------------------------------------------
 */

public class ShippedState extends OrderState {

    @Override
    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    @Override
    public void prev(OrderContext context) {
        context.setState(new ProcessingState());
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.Shipped;
    }
}