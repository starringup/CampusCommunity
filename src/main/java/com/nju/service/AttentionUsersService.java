package com.nju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.AttentionUsers;
import com.nju.repository.AttentionUsersRepository;

@Service
public class AttentionUsersService {
	@Autowired
	private AttentionUsersRepository repository;
	
	public boolean save(AttentionUsers attentionUsers){
		try{
			repository.save(attentionUsers);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
	
	public List<AttentionUsers> findAttentionsByWeChatId(String weChatId){
		try{
			return repository.findAttentionsByWeChatId(weChatId);
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<AttentionUsers>();
		}
	}
	
	public AttentionUsers findOneByAttentionWeChatIdAndAttentionedWeChatId(String attentionWeChatId,String attentionedWeChatId){
		try{
			return repository.findOneByAttentionWeChatIdAndAttentionedWeChatId(attentionWeChatId, attentionedWeChatId);
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
}
