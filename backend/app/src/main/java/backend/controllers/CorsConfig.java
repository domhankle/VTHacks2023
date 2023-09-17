package main.java.backend.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/tokens/parse").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
        registry.addMapping("/tokens/compare").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
    }
    
}
