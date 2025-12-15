package com.example.Wood.services;

import com.example.Wood.dtos.RegisterDto;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);
}
