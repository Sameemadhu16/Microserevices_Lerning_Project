error id: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/config/WebClientConfig.java:org/springframework/web/reactive/function/client/WebClient#
file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/config/WebClientConfig.java
empty definition using pc, found symbol in pc: org/springframework/web/reactive/function/client/WebClient#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 208
uri: file:///D:/3rd%20yr%20backend/Microserevices_Lerning_Project/microservices_pos/order/src/main/java/com/example/order/config/WebClientConfig.java
text:
```scala
package com.example.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.@@WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webCLient(){
        return WebClient.builder().build();
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: org/springframework/web/reactive/function/client/WebClient#