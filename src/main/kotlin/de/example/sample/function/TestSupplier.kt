package de.example.sample.function

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.function.Supplier

@Configuration(proxyBeanMethods = false)
class TestSupplier {

    @Bean
    fun test(): Supplier<Flux<String>> = Supplier {
        Flux.just("Hello World!")
    }
}