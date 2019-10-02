package com.edu.configclientapi;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name = "config-client")
public interface ConfigClientServiceProxy {

    @GetMapping("/config-client/rest/persons")
    List<Person> personList();
}
