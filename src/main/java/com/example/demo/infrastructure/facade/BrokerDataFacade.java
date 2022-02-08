package com.example.demo.infrastructure.facade;

import com.example.demo.infrastructure.representation.BrokerDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="broker-data", url = "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1")
public interface BrokerDataFacade {

    @GetMapping(path="/brokerData/{code}")
    BrokerDataResponse getBrokerData(@PathVariable("code") String code);


    @PutMapping(path="/brokerData/{code}")
    BrokerDataResponse atualizaStatus(@PathVariable("code") String code,
                                      @RequestBody BrokerDataResponse brokerDataResponse);

}
