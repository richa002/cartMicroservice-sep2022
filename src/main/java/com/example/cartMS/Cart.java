package com.example.cartMS;

import java.util.List;

public class Cart {
    public long getId() {
        return id;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public Cart(long id, List<Long> itemIds) {
        this.id = id;
        this.itemIds = itemIds;
    }

    private long id;

    public Cart() {
    }

    private List<Long> itemIds;
}
