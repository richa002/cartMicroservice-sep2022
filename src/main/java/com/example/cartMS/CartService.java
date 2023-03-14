package com.example.cartMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Map<Long, Cart> map = new HashMap<>() ;
   static  {
        map.put(1l, new Cart(1l,Arrays.asList(1l)));
        map.put(2l, new Cart(2l,Arrays.asList(2l,3l)));

    }

    public Cart findById(long id){
       logger.info("finding cart by id");
        Cart cart = map.get(id);
        if(cart==null) throw new NotFoundException("Cart Not found");
        return cart;
    }

}
