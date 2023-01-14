package com.example.test;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Data
public class CustomProperties {
    private String hostName;
    private String login;
    private String password;

}
