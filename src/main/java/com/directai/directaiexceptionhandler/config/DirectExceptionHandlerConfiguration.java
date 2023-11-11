package com.directai.directaiexceptionhandler.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackageClasses = DirectExceptionHandlerConfiguration.class)
@Configuration
@PropertySource(value = "classpath:directaiexceptionhandler-application.yml")
public class DirectExceptionHandlerConfiguration {
}
