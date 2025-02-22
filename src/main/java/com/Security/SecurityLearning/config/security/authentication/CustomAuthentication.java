package com.Security.SecurityLearning.config.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import java.util.Collection;


@Setter
@Getter
public class CustomAuthentication implements Authentication {

    private final boolean authentication;
    private final String key;
    // ✅ Explicit Constructor to prevent Lombok issues
    @Autowired
    public CustomAuthentication(boolean authentication, String key) {
        this.authentication = authentication;
        this.key = key;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    @Override
    public String getName() {
        return null;
    }
}