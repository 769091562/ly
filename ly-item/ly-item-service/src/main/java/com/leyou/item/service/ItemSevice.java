package com.leyou.item.service;

import org.springframework.stereotype.Service;

public interface ItemSevice {
    default String save(String item){
        item=item+"-----";
        return item;
    }
}
