package se.yitingchang.weatherapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        int maxInMemorySize = 10 * 1024 * 1024; // 10 MB

        return WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(maxInMemorySize))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
                .build();
    }
}

