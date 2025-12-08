error id: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderServiceImpl.java:java/util/Map#getQuantity#
file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderServiceImpl.java
empty definition using pc, found symbol in pc: java/util/Map#getQuantity#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2404
uri: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderServiceImpl.java
text:
```scala
package com.example.order.service;

import com.example.order.common.ErrorOrderResponse;
import com.example.order.common.OrderResponse;
import com.example.order.common.SuccessOrderResponse;
import com.example.order.dto.OrderDTO;
import com.example.order.model.Orders;
import com.example.order.repository.OrderRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;

import com.example.inventory.dto.InventoryDTO;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final WebClient webClient;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Orders> orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

    @Override
    public OrderResponse saveOrder(OrderDTO orderDTO) {
        Integer itemId = orderDTO.getItemId();

        try {
            Map<String, Object> inventoryResponse = webClient.get()
                .uri("http://localhost:8080/api/v1/item/{itemId}", itemId)
                .retrieve()
                .bodyToMono(InventoryDTO.class)
                .block();

            // int quantity = 0;
            // if (inventoryResponse != null) {
            //     Object q = inventoryResponse.get("quantity");
            //     if (q instanceof Number) {
            //         quantity = ((Number) q).intValue();
            //     } else if (q != null) {
            //         try {
            //             quantity = Integer.parseInt(q.toString());
            //         } catch (NumberFormatException ex) {
            //             quantity = 0;
            //         }
            //     }
            // }

            assert inventoryResponse != null;

            if (inventoryResponse.getQuantity@@() > 0) {
                orderRepo.save(modelMapper.map(orderDTO, Orders.class));
                return new SuccessOrderResponse(orderDTO);
            } else {
                return new ErrorOrderResponse("Item is out of stock or unavailable.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorOrderResponse("Failed to validate inventory: " + e.getMessage());
        }
    }

    @Override
    public OrderDTO updateOrder(OrderDTO OrderDTO) {
        orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
        return OrderDTO;
    }

    @Override
    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/Map#getQuantity#