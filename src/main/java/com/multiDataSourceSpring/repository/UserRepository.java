package com.multiDataSourceSpring.repository;

import com.multiDataSourceSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
