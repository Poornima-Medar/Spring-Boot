package com.springboot.Assignments.weekTwoAssignment.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
