package com.example.demo.infrastructure.facade;

import com.example.demo.infrastructure.representation.BrokerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="broker", url="https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1")
public interface BrokerFacade {

    @GetMapping(path="/broker/{document}")
    BrokerResponse getBrokerData(@PathVariable("document") String document);

}
