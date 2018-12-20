package com.nju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.AttentionQuestions;
import com.nju.entity.Question;
import com.nju.repository.AttentionQuestionsRepository;

@Service
public class AttentionQuestionsService {
	@Autowired
	private AttentionQuestionsRepository repository;
	
	public boolean save(AttentionQuestions attentionQuestions){
		try{
			repository.save(attentionQuestions);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
	
	public List<AttentionQuestions> findQuestionsByAttentionWeChatId(String attentionWeChatId){
		try{
			return repository.findQuestionsByAttentionWeChatId(attentionWeChatId);
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<AttentionQuestions>();
		}
	}
	
	public AttentionQuestions findAttentionQuestionByAttentionWeChatIdAndQuestionId(String attentionWeChatId,Long questionId){
		try{
			return repository.findAttentionQuestionByAttentionWeChatIdAndQuestionId(attentionWeChatId, questionId);
		}catch(Exception exception){
			return null;
		}
	}
}
