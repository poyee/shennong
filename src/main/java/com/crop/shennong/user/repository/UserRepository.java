package com.crop.shennong.user.repository;

import com.crop.shennong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByPhone(String email);

	boolean existsByPhone(String email);
}
