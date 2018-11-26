package com.leyou.search.FeginClients;

import com.leyou.item.FeginApi.SpecApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author bystander
 * @date 2018/9/22
 */
@FeignClient(value = "item-service")
public interface SpecClient extends SpecApi {
}
