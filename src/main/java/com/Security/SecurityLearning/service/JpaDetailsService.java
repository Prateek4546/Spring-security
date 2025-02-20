package com.Security.SecurityLearning.service;

import com.Security.SecurityLearning.repositories.UserRepository;

import com.Security.SecurityLearning.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaDetailsService implements UserDetailsService {
    private  final UserRepository userRepository;

    public JpaDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findUserByUsername(username);
        return u.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("User not found by this : "+username));
    }
}
