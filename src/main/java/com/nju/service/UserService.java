package com.nju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.User;
import com.nju.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User findUserByWeChatId(String weChatId){
		return userRepository.findUserByWeChatId(weChatId);
	}
	
	public boolean save(User user){
		try{
			userRepository.save(user);	
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
}
