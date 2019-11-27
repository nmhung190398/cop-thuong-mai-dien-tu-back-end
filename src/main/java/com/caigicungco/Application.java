package com.caigicungco;


import com.caigicungco.builder.ElectronicSearchBuilder;
import com.caigicungco.properties.FileStorageProperties;
import com.caigicungco.service.ElectronicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
