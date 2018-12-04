package com.leyou.page.FeginClients;

import com.leyou.item.FeginApi.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
