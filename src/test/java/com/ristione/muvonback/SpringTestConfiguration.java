package com.ristione.muvonback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@TestConfiguration
@AutoConfigureObservability
public class SpringTestConfiguration {

    @Bean
    @Primary
    public WebClient getWebClient() {
        return WebClient.builder().build();
    }
}
