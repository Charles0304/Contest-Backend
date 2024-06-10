package com.project.k6.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
