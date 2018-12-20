package com.nju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select u from User u where u.weChatId = ?1")
	User findUserByWeChatId(String weChatId);
}
