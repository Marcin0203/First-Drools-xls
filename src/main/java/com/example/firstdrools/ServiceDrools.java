package com.example.firstdrools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDrools {

    private final KieContainer kieContainer;

    @Autowired
    public ServiceDrools(KieContainer kieContainer){
        this.kieContainer = kieContainer;
    }

    public Product getProductDiscout (Product product){
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        return product;
    }
}
