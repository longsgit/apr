package com.herbalife.mysecuredapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyCustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private DatabaseAuthenticationProvider databaseAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return databaseAuthenticationProvider.authenticate(authentication);
    }
}
