package com.example.demo.service;

import com.example.demo.infrastructure.exception.UserInactive;
import com.example.demo.infrastructure.exception.UserNotFound;
import com.example.demo.infrastructure.facade.BrokerDataFacade;
import com.example.demo.infrastructure.facade.BrokerFacade;
import com.example.demo.infrastructure.representation.BrokerDataResponse;
import com.example.demo.infrastructure.representation.BrokerResponse;
import com.example.demo.model.Corretor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorretorService {

    @Autowired
    private BrokerFacade brokerFacade;

    @Autowired
    private BrokerDataFacade brokerDataFacade;


    public Corretor getCorretor(String documento){
        BrokerResponse brokerResponse;
        BrokerDataResponse brokerDataResponse;
        try{
             brokerResponse = brokerFacade.getBrokerData(documento);
             brokerDataResponse = brokerDataFacade.getBrokerData(brokerResponse.getCode());
        } catch(Exception e){
            throw new UserNotFound("Corretor nao cadastrado");
        }


        if(!brokerDataResponse.isActive()){
            throw new UserInactive("usuario nao esta ativo");
        }

        Corretor corretor = populaCorretor(brokerDataResponse, brokerResponse);

        return corretor;
    }

    public Corretor atualizarCorretorStatus(String documento, boolean status){

        BrokerResponse brokerResponse;
        BrokerDataResponse brokerDataResponse;
        try{
            brokerResponse = brokerFacade.getBrokerData(documento);
            brokerDataResponse = brokerDataFacade.getBrokerData(brokerResponse.getCode());
        } catch(Exception e){
            throw new UserNotFound("Corretor nao cadastrado");
        }

        brokerDataResponse.setActive(status);

        brokerDataFacade.atualizaStatus(brokerResponse.getCode(), brokerDataResponse);
        Corretor corretor = populaCorretor(brokerDataResponse, brokerResponse);

        return corretor;

    }

    private Corretor populaCorretor(BrokerDataResponse brokerDataResponse, BrokerResponse brokerResponse){
        Corretor corretor = new Corretor(brokerResponse.getName(),
                brokerResponse.getDocument(),
                brokerResponse.getCode(),
                brokerResponse.getCreateDate(),
                brokerDataResponse.getCommissionRate(),
                brokerDataResponse.isActive());
        return corretor;
    }
}
