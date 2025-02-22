package com.Security.SecurityLearning.config.security.managers;

import com.Security.SecurityLearning.config.security.providers.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public CustomAuthenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(customAuthenticationProvider.supports(authentication.getClass())){
           return customAuthenticationProvider.authenticate(authentication);
        }

        throw new BadCredentialsException("Oh no!");
    }
}
