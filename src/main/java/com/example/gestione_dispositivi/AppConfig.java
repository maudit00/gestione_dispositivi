package com.example.gestione_dispositivi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.Value;

@Configuration
@PropertySource("application.properties")
/**
 * AppConfig
 */
public class AppConfig {

  @Bean
  public Cloudinary getCloudinary(@Value("${cloudinary.cloud_name}") String name,
  @Value("${cloudinary.api_key}") String api_key)   
  @Value("${cloudinary.api_secret}") String api_secret){

    return new Cloudinary(ObjectUtils.asMap("cloud_name", name, "api_key", api_key, "api_secret", api_secret))
  }   
}
