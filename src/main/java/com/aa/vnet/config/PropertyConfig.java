package com.aa.vnet.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PropertyConfig
{

    @Bean
    public PropertyComponent propertyComponent()
    {
        PropertyComponent propertyComponent = new PropertyComponent();
        String profile = System.getenv("spring.profiles.active");
        log.info("profile "+profile);
        propertyComponent.setProperty(profile);
        return propertyComponent;
    }

}
