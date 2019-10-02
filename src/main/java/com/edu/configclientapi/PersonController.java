package com.edu.configclientapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PersonController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConfigClientServiceProxy proxy;

    @GetMapping("/persons")
    public ResponseEntity<?> personList() {
        try {
            System.out.println("Per-----------------");
            return ResponseEntity.ok(proxy.personList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cannot get data ");
        }
    }

    @GetMapping("/v2/persons")
    public ResponseEntity<?> convertCurrency() {
        try {
            ResponseEntity<Object> responseEntity =
                    new RestTemplate()
                            .getForEntity("http://localhost:8981/rest/persons",
                            Object.class);
            return ResponseEntity.ok(responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cannot get data ");
        }
    }

}
