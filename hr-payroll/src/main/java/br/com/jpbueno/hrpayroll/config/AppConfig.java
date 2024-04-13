package br.com.jpbueno.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Padrão de projeto SINGLETON
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
