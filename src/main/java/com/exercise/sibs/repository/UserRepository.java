package com.exercise.sibs.repository;

import com.exercise.sibs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
