package com.FullBackend.security;

import com.FullBackend.entities.User;
import com.FullBackend.exceptions.ResourceNotFoundException;
import com.FullBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from database by username
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email:" + username, 0));

        return user;
    }
}
