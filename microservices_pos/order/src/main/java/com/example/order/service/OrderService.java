package com.example.order.service;

import com.example.order.common.ErrorOrderResponse;
import com.example.order.common.OrderResponse;
import com.example.order.common.SuccessOrderResponse;
import com.example.order.dto.OrderDTO;
import com.example.order.model.Orders;
import com.example.order.repository.OrderRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderResponse saveOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO OrderDTO);
    String deleteOrder(Integer orderId);
    OrderDTO getOrderById(Integer orderId);
}

