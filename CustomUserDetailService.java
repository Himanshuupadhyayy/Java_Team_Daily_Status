package com.blogApp.Security;

import com.blogApp.Entities.User;
import com.blogApp.Exception.ResourceNotFoundException;
import com.blogApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       // loading use from database by username

    User user=this.userRepo.findByEmail(username)
            .orElseThrow(()-> new ResourceNotFoundException("User", "email"+username,0));

        return user;
    }
}
