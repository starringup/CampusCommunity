package com.nju.controller;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.AttentionQuestions;
import com.nju.entity.Question;
import com.nju.service.AttentionQuestionsService;
import com.nju.service.QuestionService;

@RestController
@RequestMapping("/attentionQuestions")
public class AttentionQuestionsController {
	@Autowired
	private AttentionQuestionsService attentionQuestionsService;
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/{attentionWeChatId}/{questionId}")
	public String attention(@PathVariable String attentionWeChatId,@PathVariable String questionId){
		if(attentionQuestionsService.findAttentionQuestionByAttentionWeChatIdAndQuestionId(attentionWeChatId, Long.parseLong(questionId.trim())) != null){
			return "successful";
		}
		AttentionQuestions attentionQuestions = new AttentionQuestions();
		attentionQuestions.setAttentionWeChatId(attentionWeChatId);
		attentionQuestions.setQuestionId(Long.parseLong(questionId.trim()));
		if(attentionQuestionsService.save(attentionQuestions)){
			return "successful";
		}else{
			return "failed";
		}
	}
	
	@RequestMapping("/{attentionWeChatId}")
	public String attentionQuestions(@PathVariable String attentionWeChatId){
		List<AttentionQuestions> attentions = attentionQuestionsService.findQuestionsByAttentionWeChatId(attentionWeChatId);
		Iterator<AttentionQuestions> attentionsItr = attentions.iterator();
		JSONArray jsonArray = new JSONArray();
		while(attentionsItr.hasNext()){
			AttentionQuestions attention = attentionsItr.next();
			try{
				Question question = questionService.findQuestionById(attention.getQuestionId());
				jsonArray.put(new JSONObject(question.toString()));
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return jsonArray.toString();
	}
}
