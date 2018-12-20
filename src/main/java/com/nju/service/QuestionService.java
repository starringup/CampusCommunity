package com.nju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.Question;
import com.nju.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question save(Question question){
		try{
			return questionRepository.save(question);
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	public List<Question> findAll(){
		try{
			return questionRepository.findAll();
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<Question>();
		}
	}
	
	public Question findQuestionById(Long id){
		return questionRepository.findQuestionById(id);
	}
}
