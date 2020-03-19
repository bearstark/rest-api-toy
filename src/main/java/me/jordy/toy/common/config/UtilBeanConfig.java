package me.jordy.toy.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilBeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
