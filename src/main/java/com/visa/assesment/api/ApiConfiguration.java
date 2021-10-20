package com.visa.assesment.api;

import com.visa.assesment.utils.TokenUtils;
import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SignatureException;

@Configuration
public class ApiConfiguration {

    @Value("${client.visa.apiKey}")
    private String apiKey;

    @Value("${client.visa.sharedSecret}")
    private String sharedSecret;

    @Value("${client.visa.resourcePath}")
    private String resourcePath;

    @Bean
    public RequestInterceptor requestInterceptor() {
        String queryString = "apikey=" + apiKey;
        return requestTemplate -> {
            String xPayToken = "";
            try {
                xPayToken = TokenUtils.generateXpaytoken(resourcePath, queryString, "", sharedSecret);
            } catch (SignatureException e) {
                e.printStackTrace();
            }
            System.out.println("x-pay-token:" + xPayToken);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
            requestTemplate.header("x-pay-token", xPayToken);
        };
    }
}
