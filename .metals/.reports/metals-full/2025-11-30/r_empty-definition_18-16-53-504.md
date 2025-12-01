error id: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/inventory/src/main/java/com/example/inventory/controller/InventoryController.java:com/example/inventory/dto/InventoryDTO#
file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/inventory/src/main/java/com/example/inventory/controller/InventoryController.java
empty definition using pc, found symbol in pc: com/example/inventory/dto/InventoryDTO#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 78
uri: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/inventory/src/main/java/com/example/inventory/controller/InventoryController.java
text:
```scala
package com.example.inventory.controller;

import com.example.inventory.dto.@@InventoryDTO;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getitems")
    public List<InventoryDTO> getItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/item/{itemId}")
    public InventoryDTO getItemById(@PathVariable Integer itemId) {
        return inventoryService.getItemById(itemId);
    }
 
    @PostMapping("/additem")
    public InventoryDTO saveItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveItem(inventoryDTO);
    }

    @PutMapping("/updateitem")
    public InventoryDTO updateItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateItem(inventoryDTO);
    }

    @DeleteMapping("/deleteitem/{itemId}")
    public String deleteItem(@PathVariable Integer itemId) {
        return inventoryService.deleteItem(itemId);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/inventory/dto/InventoryDTO#