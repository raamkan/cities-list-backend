package com.challenge.citylists;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "City Lists API", version = "1.0", description = "All Cities and its photos catalog"))
public class CityListApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityListApplication.class, args);
    }
}
