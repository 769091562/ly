package com.leyou.item.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.service.ItemSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemSevice itemSevice;

    @PostMapping
    public ResponseEntity saveItem(String item){
        if("".equals(item) || null==item){
            throw new LyException(ExceptionEnum.GOODS_NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(itemSevice.save(item));

    }

}
