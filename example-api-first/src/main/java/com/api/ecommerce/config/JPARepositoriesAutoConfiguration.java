package com.api.ecommerce.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.api.ecommerce.entity")
@EnableJpaRepositories(value = "com.api.ecommerce.repository")
public class JPARepositoriesAutoConfiguration {
}
