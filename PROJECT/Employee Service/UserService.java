package com.example.EMS.service;

import com.example.EMS.dto.UserRegistrationDto;
import com.example.EMS.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto); 
}

