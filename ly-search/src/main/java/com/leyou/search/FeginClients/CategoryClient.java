package com.leyou.search.FeginClients;

import com.leyou.item.FeginApi.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface CategoryClient extends CategoryApi{
}
