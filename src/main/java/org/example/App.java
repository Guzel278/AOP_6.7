package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.component.ExampleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableAspectJAutoProxy
//@SpringBootApplication
public class App {
    static final Logger logger = LogManager.getLogger(App.class);
    @Autowired
    private ExampleClass exampleClass;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunner(ApplicationContext ctx){
        return args -> {
            logger.info("Äpplication started");
            String value = exampleClass.methodOne("X5");
            value = exampleClass.methodOne("X5");
            logger.info("Value length " + value.length());
            exampleClass.methodTwo(); {
            try {
                exampleClass.methodThree();
            }
            catch (RuntimeException e){
                logger.error(e.getMessage());
            }
            logger.info("Äpplication fished");
            }
        };
    }

}