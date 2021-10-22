package com.visa.assesment.controller;

import com.visa.assesment.service.VdpHelloWorldClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class VdpHelloWorldController {

  @Autowired private VdpHelloWorldClient vdpHelloWorldClient;

  @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
  public String getVdpHelloWorld() {
    return vdpHelloWorldClient.getVdpHelloWorld();
  }
}
