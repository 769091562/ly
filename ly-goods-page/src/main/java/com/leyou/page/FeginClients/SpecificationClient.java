package com.leyou.page.FeginClients;

import com.leyou.item.FeginApi.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface SpecificationClient extends SpecificationApi {
}
