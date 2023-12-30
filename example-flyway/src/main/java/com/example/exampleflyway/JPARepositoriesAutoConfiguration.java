package com.example.exampleflyway;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.exampleflyway")
@EnableJpaRepositories(value = "com.example.exampleflyway")
public class JPARepositoriesAutoConfiguration {
}
