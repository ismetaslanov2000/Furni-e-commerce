package com.example.Wood.services.impls;

import com.example.Wood.dtos.RegisterDto;
import com.example.Wood.models.User;
import com.example.Wood.repositories.UserRepository;
import com.example.Wood.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public boolean registerUser(RegisterDto registerDto) {
        User findUser=userRepository.findByEmail(registerDto.getUsername());
        if ((findUser!=null)){
            return false;
        }
        User user=new User();
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());


        String password=passwordEncoder.encode(registerDto.getPassword());//cefer12//?fefhire12234
        user.setPassword(password);
        userRepository.save(user);
        return true;



    }
}
