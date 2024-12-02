package org.example.trainingproject.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource


@Configuration
@ComponentScan(basePackages = ["org.example.trainingproject"])
@PropertySource("classpath:/application.properties")
class TestConfig