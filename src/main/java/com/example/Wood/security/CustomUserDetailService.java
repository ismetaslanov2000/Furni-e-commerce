package com.example.Wood.security;

import com.example.Wood.models.User;
import com.example.Wood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;
@Configuration

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User findUser = userRepository.findByEmail(email);
            System.out.println(findUser.toString());

            org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(
                    findUser.getEmail(),
                    findUser.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    findUser.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
            );

            return user;
        }catch (Exception e){
            throw new UsernameNotFoundException(e.getMessage());

        }

    }
}
