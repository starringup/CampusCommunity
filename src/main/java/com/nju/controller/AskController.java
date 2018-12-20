package com.nju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.Ask;
import com.nju.entity.Question;
import com.nju.service.AskService;
import com.nju.service.QuestionService;

@RestController
@RequestMapping("/ask")
public class AskController {
	@Autowired
	private AskService askService;
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/{askerWeChatId}",method = RequestMethod.POST)
	public String askQuestion(@PathVariable String askerWeChatId,
							@RequestParam(value = "title",required = true) String title,
							@RequestParam(value = "details",required = true) String details){
		Question question = new Question();
		question.setDetails(details);
		question.setTitle(title);
		question.setOpen(true);
		question = questionService.save(question);
		if(question == null){
			return "failed";
		}
		Ask ask = new Ask();
		ask.setAskerWeChatId(askerWeChatId);
		ask.setQuestionId(question.getId());
		if(askService.save(ask)){
			return question.toString();//"success";
		}else{
			return "failed";
		}
	}
	
	@RequestMapping("/close/{askerWeChatId}/{questionId}")
	public String close(@PathVariable String askerWeChatId,@PathVariable String questionId){
		if(askService.findAskByAskerWeChatIdAndQuestionId(askerWeChatId, Long.parseLong(questionId.trim())) == null){
			return "failed";
		}
		try{
			Question question = questionService.findQuestionById(Long.parseLong(questionId.trim()));	
			question.setOpen(false);
			questionService.save(question);
			return "successful";
		}catch(Exception exception){
			return "failed";
		}
	}
}
