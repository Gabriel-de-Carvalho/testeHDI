package com.example.demo.infrastructure.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerDataResponse {

    private String code;
    private boolean active;
    private float commissionRate;

}
