package org.example.trainingproject.stepdefinitions

import io.cucumber.spring.CucumberContextConfiguration
import org.example.trainingproject.config.TestConfig
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.ContextConfiguration

@WebFluxTest(excludeAutoConfiguration = [ReactiveUserDetailsServiceAutoConfiguration::class])
@CucumberContextConfiguration
@ContextConfiguration(classes = [TestConfig::class])
class CucumberSpringConfiguration