package com.visa.assesment.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(value = "jplaceholder",
//        url = "https://sl73vilsapd001.visa.com:8443",
//        configuration = ApiConfiguration.class)
//public interface VdpHelloWorldClient {
//    @RequestMapping(method = RequestMethod.GET, value = "/installment/installments/version")
//    String getVdpHelloWorld();
//}

@FeignClient(value = "jplaceholder",
        url = "https://sandbox.api.visa.com",
        configuration = ApiConfiguration.class)
public interface VdpHelloWorldClient {
    @RequestMapping(method = RequestMethod.GET,
            value = "/vdp/helloworld?apikey=ETTDNFOWT57R8FNGOWBH21LD3QZlBgvRdehaNLjR1HYW5cwH4")
    String getVdpHelloWorld();
}