package jqmicrosistemas.abacus

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ApiAbacusApplication {

    static void main(String[] args) {
        SpringApplication.run(ApiAbacusApplication, args)
    }

}
