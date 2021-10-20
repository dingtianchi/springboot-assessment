package com.visa.assesment.api;

import com.visa.assesment.utils.TokenUtils;
import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SignatureException;

@Configuration
public class ApiConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        String queryString = "apikey=ETTDNFOWT57R8FNGOWBH21LD3QZlBgvRdehaNLjR1HYW5cwH4";
        String sharedSecret = "XO8bbmBed4/Qy-Ayw$W1m40mF9{bC-WiaHB}G0/M";
        return requestTemplate -> {
            String xPayToken = "";
            try {
                xPayToken = TokenUtils.generateXpaytoken("helloworld",
                        queryString, "", sharedSecret);
            } catch (SignatureException e) {
                e.printStackTrace();
            }
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
            requestTemplate.header("x-pay-token", xPayToken);
            requestTemplate.header("X-API-KEY", "SVC_ARM:Pud723UbAP");
        };
    }
}
