package com.leyou.page.FeginClients;

import com.leyou.item.FeginApi.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {
}
