package com.example.springbootmysql.config;

import com.example.springbootmysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private User user;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(user.getUserName());
    }
}