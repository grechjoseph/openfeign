package com.jg.openfeign.feign;

import com.jg.openfeign.config.FeignConfig;
import com.jg.openfeign.feign.response.ForexResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.forex-api.name:forex-api}",
        url = "${feign.forex-api.url:https://www.freeforexapi.com/api/live}",
        configuration = FeignConfig.class)
public interface ForexApiClient {

    @GetMapping
    ForexResponse getForexRate(@RequestParam("pairs") final String pairs);
}
