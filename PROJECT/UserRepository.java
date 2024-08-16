package com.example.user_serv.repository;
import com.example.user_serv.entity.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    Optional<User> findByUsername(String username);

}
