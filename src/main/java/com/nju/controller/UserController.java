package com.nju.controller;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.Answer;
import com.nju.entity.AttentionUsers;
import com.nju.entity.User;
import com.nju.service.AnswerService;
import com.nju.service.AttentionUsersService;
import com.nju.service.UserService;

import com.nju.configuration.*;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AttentionUsersService attentionUsersService;
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping("/{weChatId}")
	public String getUserByWeChatId(@PathVariable String weChatId){
		User user = userService.findUserByWeChatId(weChatId);
		try{
			return user.toString();
		}catch(NullPointerException exception){
			User newUser = new User();
			newUser.setWeChatId(weChatId);
			newUser.setName(weChatId);
			newUser.setHeadPortraitUrl(DefaultVariable.headPortriatUrl);
			if(userService.save(newUser)){
				user = userService.findUserByWeChatId(weChatId);
				return user.toString();	
			}else{
				return "error";
			}
		}
	}
	
	@RequestMapping("/attentionRecentAnswers/{weChatId}")
	public String getAttentionRecentAnswers(@PathVariable String weChatId){
		List<AttentionUsers> attentions = attentionUsersService.findAttentionsByWeChatId(weChatId);
		JSONArray jsonArray = new JSONArray();
		Iterator<AttentionUsers> attentionsItr = attentions.iterator();
		while(attentionsItr.hasNext()){
			AttentionUsers attetion = attentionsItr.next();
			try{
				Answer answer = answerService.findRecentAnswerByAnswererId(attetion.getAttentionedWeChatId());
				jsonArray.put(new JSONObject(answer.toString()));	
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return jsonArray.toString();
	}
	
}
