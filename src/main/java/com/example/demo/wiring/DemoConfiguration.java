package com.example.demo.wiring;

import com.example.demo.persistence.MapBasedMerchantRepository;
import com.example.demo.persistence.MerchantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public MerchantRepository merchantRepository() {
        return new MapBasedMerchantRepository();
    }
}
