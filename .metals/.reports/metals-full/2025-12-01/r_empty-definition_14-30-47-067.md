error id: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderService.java:com/example/order/common/ErrorOrderResponse#
file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderService.java
empty definition using pc, found symbol in pc: com/example/order/common/ErrorOrderResponse#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 70
uri: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/service/OrderService.java
text:
```scala
package com.example.order.service;

import com.example.order.common.@@ErrorOrderResponse;
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
// import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import org.springframework.core.ParameterizedTypeReference;
import java.util.Map;

@Service
@Transactional
public class OrderService {

    private final WebClient webClient;


    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders>orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public OrderResponse saveOrder(OrderDTO orderDTO) {

        Integer itemId = orderDTO.getItemId();

        try {
            Map<String, Object> inventoryResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("http://localhost:8080/api/v1/item/{itemId}").build(itemId))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();

            int quantity = 0;
            if (inventoryResponse != null) {
                Object q = inventoryResponse.get("quantity");
                if (q instanceof Number) {
                    quantity = ((Number) q).intValue();
                } else if (q != null) {
                    try {
                        quantity = Integer.parseInt(q.toString());
                    } catch (NumberFormatException ex) {
                        quantity = 0;
                    }
                }
            }

            if (inventoryResponse != null && quantity > 0) {
                orderRepo.save(modelMapper.map(orderDTO, Orders.class));
                return new SuccessOrderResponse(orderDTO);
            } else {
                // item not available or no inventory info; return null or throw a custom exception as needed
                return new ErrorOrderResponse("Item is out of stock or unavailable.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    public OrderDTO updateOrder(OrderDTO OrderDTO) {
        orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
        return OrderDTO;
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/order/common/ErrorOrderResponse#