package org.example.trainingproject.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient


/**
 * Configuration class for WebClient setup.
 *
 * This configuration provides a centralized way to create and configure the WebClient
 * instance used for making HTTP requests to the Pet Store API.
 */

@Configuration
class WebClientConfig {
    /**
     * Creates and configures a WebClient bean with default settings.
     *
     * The WebClient is configured with:
     * - Base URL for the Pet Store API
     * - Default headers for JSON content type and accept
     * - Default timeout configurations
     *
     * @return Configured WebClient instance
     */
    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://petstore.swagger.io/v2")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
}