package com.example.demo.employers;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployersConfig
{
    @Bean
    CommandLineRunner commandLineRunner(EmployersRepository repository)
    {
        
        return args -> {
               Employers John = new Employers(
                    1,"John Smith","john.smith@gmail.com","8-621-22147"
                );

                Employers Pete = new Employers(
                    2,"Pete Doe","pete.doe@gmail.com","8-321-12345"
                );

                repository.saveAll(List.of(John, Pete));

        };
        
    }
}