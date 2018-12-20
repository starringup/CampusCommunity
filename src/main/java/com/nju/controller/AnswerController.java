package com.nju.controller;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.Answer;
import com.nju.entity.Comment;
import com.nju.service.AnswerService;
import com.nju.service.CommentService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/getComments/{answerId}")
	public String getComments(@PathVariable String answerId){
		List<Comment> comments = commentService.findCommentsByAnswerId(Long.parseLong(answerId.trim()));
		Iterator<Comment> commentItr = comments.iterator();
		JSONArray jsonArray = new JSONArray();
		while(commentItr.hasNext()){
			Comment comment = commentItr.next();
			try{
				jsonArray.put(new JSONObject(comment.toString()));
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return jsonArray.toString();
	}
	
	@RequestMapping("/myAnswers/{weChatId}")
	public String myAnswers(@PathVariable String weChatId){
		List<Answer> answers = answerService.findAnswersByAnswererId(weChatId);
		JSONArray jsonArray = new JSONArray();
		Iterator<Answer> answersItr = answers.iterator();
		while(answersItr.hasNext()){
			Answer answer = answersItr.next();
			try{
				jsonArray.put(new JSONObject(answer.toString()));
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return jsonArray.toString();
	}
	
	@RequestMapping(value = "/answerQuestion",method = RequestMethod.POST)
	public String answerQuestion(@RequestParam(value = "questionId",required = true) Long questionId,
								@RequestParam(value = "answererId",required = true) String answererId,
								@RequestParam(value = "content",required = true) String content,
								@RequestParam(value = "anonymous",required = false) boolean anonymous){
		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setAnswererId(answererId);
		answer.setContent(content);
		answer.setAnonymous(anonymous == true ? anonymous : false);
		if(answerService.save(answer)){
			return "successful";
		}else{
			return "failed";
		}
	}
}
