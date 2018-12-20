package com.nju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.Ask;
import com.nju.repository.AskRepository;

@Service
public class AskService {
	@Autowired
	private AskRepository askRepository;
	
	public boolean save(Ask ask){
		try{
			askRepository.save(ask);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
	
	public Ask findAskByAskerWeChatIdAndQuestionId(String askerWeChatId,Long questionId){
		try{
			return askRepository.findAskByAskerWeChatIdAndQuestionId(askerWeChatId, questionId);
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
}
