package com.example.EMS.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EMS.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
