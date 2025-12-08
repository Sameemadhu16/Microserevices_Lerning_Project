error id: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/controller/OrderController.java:com/example/order/dto/OrderDTO#
file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/controller/OrderController.java
empty definition using pc, found symbol in pc: com/example/order/dto/OrderDTO#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 118
uri: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/controller/OrderController.java
text:
```scala
package com.example.order.controller;

import com.example.order.common.OrderResponse;
import com.example.order.dto.@@OrderDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/getorders")
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/addOrder")
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/updateorder")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/order/dto/OrderDTO#