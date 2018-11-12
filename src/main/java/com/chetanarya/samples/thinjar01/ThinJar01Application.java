package com.chetanarya.samples.thinjar01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ThinJar01Application {

    public static void main(String[] args) {
        SpringApplication.run(ThinJar01Application.class, args);
    }
}

@Configuration
class ExampleRouter {
    @Bean
    public RouterFunction<ServerResponse> route(ExampleHandler exampleHandler) {
        return RouterFunctions
                .route(
                        //curl  http://localhost:8080/example
                        RequestPredicates.GET("/example").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), exampleHandler::hello
                );
    }
}

@Component
class ExampleHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Poonam"));
    }
}