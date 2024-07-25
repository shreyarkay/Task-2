package com.example.Task7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Task7.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
