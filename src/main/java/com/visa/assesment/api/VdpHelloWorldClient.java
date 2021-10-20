package com.visa.assesment.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "apiClient",
        url = "${client.visa.baseUrl}",
        configuration = ApiConfiguration.class)
public interface VdpHelloWorldClient {
    @RequestMapping(method = RequestMethod.GET, value = "${client.visa.helloWorldApi}")
    String getVdpHelloWorld();
}