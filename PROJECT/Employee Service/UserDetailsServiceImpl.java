package com.example.EMS.service;

import com.example.EMS.entity.Employee;
import com.example.EMS.entity.User;
import com.example.EMS.repository.EmployeeRepository;
import com.example.EMS.repository.UserRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

	public Object getCurrentUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}
}

