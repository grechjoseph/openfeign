package com.jg.openfeign.feign.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForexResponse implements Serializable {

    private static final long serialVersionUID = 664138904625428229L;

    private int code;
    private Map<String, Rate> rates;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rate {

        private double rate;
        private long timestamp;

    }

}
