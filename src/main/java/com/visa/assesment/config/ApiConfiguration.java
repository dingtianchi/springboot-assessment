package com.visa.assesment.config;

import com.visa.assesment.utils.XPayTokenUtil;
import feign.RequestInterceptor;
import java.security.SignatureException;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        xPayToken = XPayTokenUtil.generateXpaytoken(resourcePath, queryString, "", sharedSecret);
      } catch (SignatureException e) {
        e.printStackTrace();
      }
      System.out.println("x-pay-token:" + xPayToken);
      requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
      requestTemplate.header("x-pay-token", xPayToken);
    };
  }
}
