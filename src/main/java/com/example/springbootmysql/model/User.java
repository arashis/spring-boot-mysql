package com.example.springbootmysql.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class User {
    private String userName;
}
