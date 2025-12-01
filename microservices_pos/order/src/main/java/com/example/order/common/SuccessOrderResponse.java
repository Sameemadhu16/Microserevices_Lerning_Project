package com.example.order.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.example.order.dto.OrderDTO;
import lombok.Getter;

@Getter
public class SuccessOrderResponse implements OrderResponse {
    @JsonUnwrapped //get order object in the root level
    private final OrderDTO order;

    public SuccessOrderResponse(OrderDTO order) {
        this.order = order;
    }
}
