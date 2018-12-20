package com.nju.controller;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.Question;
import com.nju.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/getQuestions")
	public String getQuestions(){
		List<Question> questions = questionService.findAll();
		Iterator<Question> questionItr = questions.iterator();
		JSONArray jsonArray = new JSONArray();
		while(questionItr.hasNext()){
			Question question = questionItr.next();
			try{
				jsonArray.put(new JSONObject(question.toString()));
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return jsonArray.toString();
	}
}
