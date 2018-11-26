package com.leyou.search.FeginClients;

import com.leyou.item.FeginApi.SpecApi;
import com.leyou.item.FeginApi.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface SpecificationClient extends SpecificationApi {
}
