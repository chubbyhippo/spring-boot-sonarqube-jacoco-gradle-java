package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    private WebTestClient webTestClient;


    @Test
    @DisplayName("should not throw any errors")
    void shouldNotThrowAnyErrors() {
        assertThatNoException().isThrownBy(() -> DemoApplication.main(new String[]{"--server.port=0"}));
    }

    @Test
    @DisplayName("should return hello")
    void shouldReturnHello() {
        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectBody(String.class)
                .value(s -> assertThat(s)
                        .isEqualTo("hello"));
    }
}
