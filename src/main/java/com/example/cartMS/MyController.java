package com.example.cartMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RefreshScope
public class MyController {
  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;

    @GetMapping("/msg")
    public String getMsg() {
        return this.msg;
    }

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CartService cartService;


    @GetMapping("/orders/{id}")
    @HystrixCommand(fallbackMethod = "getItmesInOrderFallback",
            ignoreExceptions = { NotFoundException.class })
    public OrderResponse getItmesInOrder(@PathVariable long id) {
        logger.info("Recived order request");
        System.out.println("original method");
        Cart cart = cartService.findById(id);
        String url = "http://itemMS/items/";
        OrderResponse response = new OrderResponse();
        response.setOrderId(id);
        List<Item> itemList = cart.getItemIds().stream()
                .map(itemId -> {
                    Item item = restTemplate.getForObject(url + itemId, Item.class);
                    System.out.println("recieved item :"+item);
                    return  item;
                }).collect(Collectors.toList());

        response.setItems(itemList);
        return response;
    }

    public OrderResponse getItmesInOrderFallback(@PathVariable long id) {
        System.out.println("fallback method");
        return new OrderResponse(id, new ArrayList<>());
    }

}
