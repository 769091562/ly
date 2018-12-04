package com.leyou.page.controller;

import com.leyou.page.servcie.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("item")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("{id}.html")
    public String toItemPage(Model model, @PathVariable("id") Long id) throws Exception {
        log.debug("进入方法"+id);

        Map<String, Object> modelMap = goodsService.loadModel(id);

        model.addAttribute(modelMap);

        return "item";
    }
}
