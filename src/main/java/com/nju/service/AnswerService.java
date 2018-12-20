package com.nju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.Answer;
import com.nju.repository.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	public boolean save(Answer answer){
		try{
			answerRepository.save(answer);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
	
	public Answer findRecentAnswerByAnswererId(String answererId){
		try{
			return answerRepository.findRecentAnswerByAnswererId(answererId);
		}catch(Exception exception){
			exception.printStackTrace();
			return new Answer();
		}
	}
	
	public List<Answer> findAnswersByAnswererId(String answererId){
		try{
			return answerRepository.findAnswersByAnswererId(answererId);
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<Answer>();
		}
	}
}
