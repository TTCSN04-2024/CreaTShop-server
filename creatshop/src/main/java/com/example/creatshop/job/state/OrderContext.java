package com.example.creatshop.job.state;

import com.example.creatshop.constant.OrderStatus;

/**
 * ----------------------------------------------------------------------------
 * Author:        Hong Anh
 * Created on:    14/12/2024 at 11:22 PM
 * Project:       CreaTShop-server
 * Contact:       https://github.com/lehonganh0201
 * ----------------------------------------------------------------------------
 */

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new ProcessingState(); // Trạng thái mặc định
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    public void next() {
        state.next(this);
    }

    public void prev() {
        state.prev(this);
    }

    public OrderStatus getStatus() {
        return state.getStatus();
    }
}
