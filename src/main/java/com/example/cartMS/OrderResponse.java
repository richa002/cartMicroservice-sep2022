package com.example.cartMS;

import java.util.List;

public class OrderResponse {
   private long orderId;

    public OrderResponse(long orderId, List<Item> itmes) {
        this.orderId = orderId;
        this.itmes = itmes;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderResponse() {
    }

    public List<Item> getItmes() {
        return itmes;
    }

    public void setItems(List<Item> itmes) {
        this.itmes = itmes;
    }

    private List<Item> itmes;
}
