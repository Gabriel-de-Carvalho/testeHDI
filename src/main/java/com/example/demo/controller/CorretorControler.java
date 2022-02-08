package com.example.demo.controller;

import com.example.demo.infrastructure.representation.BrokerDataResponse;
import com.example.demo.model.Corretor;
import com.example.demo.service.CorretorService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/corretores")
public class CorretorControler {

    @Autowired
    private CorretorService corretorService;

    @GetMapping("/corretor/{documento}")
    public ResponseEntity getCorretor(@PathVariable("documento") String documento){
        Corretor corretor = corretorService.getCorretor(documento);

        return ResponseEntity.ok().body(corretor);
    }

    @PutMapping("/corretor/{documento}")
    public ResponseEntity atualizaCorretor(@PathVariable("documento") String documento, @RequestBody Corretor corretor){
        Corretor novoCorretor = corretorService.atualizarCorretorStatus(documento, corretor.isAtivo());
        return ResponseEntity.ok().body(novoCorretor);
    }

}
