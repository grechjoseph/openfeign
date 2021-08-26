package com.jg.openfeign.controller;

import com.jg.openfeign.feign.ForexApiClient;
import com.jg.openfeign.feign.response.ForexResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ForexController {

    private final ForexApiClient forexApiClient;

    @GetMapping("/forex/{from}/{to}")
    public double getForexRate(@PathVariable final String from, @PathVariable final String to) {
        return forexApiClient.getForexRate(from.toUpperCase() + to.toUpperCase())
                .getRates()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(from + to))
                .findFirst()
                .map(Map.Entry::getValue)
                .map(ForexResponse.Rate::getRate)
                .orElseThrow(UnsupportedOperationException::new);

    }

}
