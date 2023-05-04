package com.herbalife.mysecuredapp.service;

import com.herbalife.mysecuredapp.entity.AppUser;
import com.herbalife.mysecuredapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(username);
        if (optionalAppUser.isPresent()) {
            AppUser appUser = optionalAppUser.get();
            UserDetails userDetails = User
                    .withUsername(username)
                    .password(appUser.getPassword())
                    .authorities("user")
                    .build();
            System.out.println(userDetails);
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username + " does not exist");
        }
    }

    public void save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }
}
