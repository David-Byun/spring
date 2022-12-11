package com.example.test.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
