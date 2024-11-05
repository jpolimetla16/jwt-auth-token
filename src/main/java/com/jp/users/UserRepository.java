package com.jp.users;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	Optional<UserEntity> findByUserId(String userId);
	Optional<UserEntity> findByEmail(String email);

}
